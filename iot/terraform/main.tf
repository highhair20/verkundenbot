provider "aws" {
  profile = "${var.aws_profile}"
  region = "${var.aws_region}"
}

/*
    Create an IoT Thing Type

    Thing types allow you to store description and configuration information that is common to all things
    associated with the same thing type. This simplifies the management of things in the registry.
    For example, you can define a LightBulb thing type. All things associated with the LightBulb thing
    type share a set of attributes: serial number, manufacturer, and wattage. When you create a thing of
    type LightBulb (or change the type of an existing thing to LightBulb) you can specify values for each of
    the attributes defined in the LightBulb thing type.

    Ref: https://docs.aws.amazon.com/iot/latest/developerguide/thing-types.html
 */
resource "aws_iot_thing_type" "this" {
  name  = "VerkundenbotThingType"
  properties {
    description = "Verkundenbot Thing Type"
    searchable_attributes = [
        "model",
        "device-id"
    ]
  }
}

/*
    Create an IoT Thing Policy

    AWS IoT Core policies allow you to control access to the AWS IoT Core data plane. The AWS IoT Core data
    plane consists of operations that allow you to connect to the AWS IoT Core message broker, send and receive
    MQTT messages, and get or update a thing's Device Shadow.

    Ref: https://docs.aws.amazon.com/iot/latest/developerguide/iot-policies.html
 */
resource "aws_iot_policy" "this" {
  name      = "VerkundenbotPolicy"
  policy    = jsonencode({
    Version = "2012-10-17",
    Statement = [
      {
        Effect   = "Allow",
        Action   = [
          "iot:Connect",
        ],
        Resource = [
            "arn:aws:iot:${var.aws_region}:${var.aws_account_id}:client/${var.client_id}",
        ],
      },
      {
        Effect   = "Allow",
        Action   = [
          "iot:Subscribe",
        ],
        Resource = [
            "arn:aws:iot:${var.aws_region}:${var.aws_account_id}:topicfilter/verkundenbot/${var.device_id}/#",
        ],
      },
      {
        Effect   = "Allow",
        Action   = [
          "iot:Publish",
          "iot:Receive",
        ],
        Resource = [
            "arn:aws:iot:${var.aws_region}:${var.aws_account_id}:topic/verkundenbot/${var.device_id}/plug1",
            "arn:aws:iot:${var.aws_region}:${var.aws_account_id}:topic/verkundenbot/${var.device_id}/plug2",
            "arn:aws:iot:${var.aws_region}:${var.aws_account_id}:topic/verkundenbot/${var.device_id}/plug3",
            "arn:aws:iot:${var.aws_region}:${var.aws_account_id}:topic/verkundenbot/${var.device_id}/plug4"
        ],
      },
    ],
  })
}


# Create an IoT Thing
resource "aws_iot_thing" "this" {
  name        = "VerkundenbotThing-${var.device_id}"
  attributes    = {
    "model": "0.1",
    "device-id": "${var.device_id}"
  }
  thing_type_name = aws_iot_thing_type.this.name
}

resource "aws_iot_certificate" "cert" {
  active = true
}

# Attach the IoT Thing Policy to the IoT Thing
resource "aws_iot_policy_attachment" "this" {
  policy = aws_iot_policy.this.name
  target = aws_iot_certificate.cert.arn
}

resource "aws_iot_thing_group" "parent" {
  name = "parent"
}

resource "aws_iot_thing_group" "this" {
  name = "vkb-group"

  parent_group_name = aws_iot_thing_group.parent.name

  properties {
    attribute_payload {
      attributes = {
        One = "11111"
        Two = "TwoTwo"
      }
    }
    description = "This is my thing group"
  }

  tags = {
    terraform = "true"
  }
}





















#the thing certificate
resource "aws_iot_certificate" "thing-certificate" {
  active = true
}

# attach thing to certificate
resource "aws_iot_thing_principal_attachment" "thing-certificate-attachment" {
  principal = "${aws_iot_certificate.thing-certificate.arn}"
  thing     = "${aws_iot_thing.this.name}"
}

#certificate iot policy
data "aws_iam_policy_document" "thing-policy-document" {
  statement {
    sid    = "1"
    effect = "Allow"
    actions = [
      "iot:*",
    ]
    resources = [
      "*",
    ]
  }
}

resource "aws_iot_policy" "thing-policy" {
  name   = "${aws_iot_thing_group.this.name}-policy"
  policy = "${data.aws_iam_policy_document.thing-policy-document.json}"
}

resource "aws_iot_policy_attachment" "thing-policy-attachment" {
  policy = "${aws_iot_policy.thing-policy.name}"
  target = "${aws_iot_certificate.thing-certificate.arn}"
}

#assume with certificate policy
data "aws_iam_policy_document" "thing-assume-with-cert-policy-document" {
  statement {
    sid    = "2"
    effect = "Allow"
    actions = [
      "iot:AssumeRoleWithCertificate",
    ]
    resources = [
      "${aws_iot_role_alias.thing-service-role-alias.arn}",
    ]
  }
}

resource "aws_iot_policy" "thing-assume-with-cert-policy" {
  name   = "${aws_iot_thing_group.this.name}-assume-with-cert-policy"
  policy = "${data.aws_iam_policy_document.thing-assume-with-cert-policy-document.json}"
}

resource "aws_iot_policy_attachment" "thing-assume-with-cert-policy-attachment" {
  policy = "${aws_iot_policy.thing-assume-with-cert-policy.name}"
  target = "${aws_iot_certificate.thing-certificate.arn}"
}


resource "aws_iot_topic_rule" "thing-shadow-rule" {
  name        = "ThingShadowRule"
  description = "ThingShadowRule"
  enabled     = true
  sql         = "SELECT * , topic(3) as thingname , timestamp() as logtimestamp FROM '$aws/things/+/shadow/update'"
  sql_version = "2016-03-23"

  s3 {
    bucket_name = "${aws_s3_bucket.thing-shadow-bucket.bucket}"
    role_arn    = "${aws_iam_role.thing-shadow-rule-role.arn}"
    key         = "things/shadow/$${parse_time(\"yyyy/MM/dd/HH\", timestamp(), \"UTC\")}/$${topic(3)}-$${timestamp()}.json"
  }
}




