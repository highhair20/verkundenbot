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
  name  = "vkb-thing-type"
  properties {
    description = "Verkundenbot Thing Type"
    searchable_attributes = [
        "model",
        "device-id"
    ]
  }
}

resource "aws_iot_thing" "thing" {
  name     = "vkb-thing-${var.device_id}"
  thing_type_name = aws_iot_thing_type.this.name
  attributes = {
    Name = "vkb-thing-${var.device_id}"
  }
}

resource "aws_iot_thing_group" "this" {
  name = "vkb-thing-group"

  properties {
    attribute_payload {
      attributes = {
        One = "11111"
        Two = "TwoTwo"
      }
    }
    description = "This is the Verkundenbot thing group"
  }

  tags = {
    terraform = "true"
  }
}

resource "aws_iot_thing_group_membership" "this" {
  thing_name       = aws_iot_thing.thing.name
  thing_group_name = aws_iot_thing_group.this.name

  override_dynamic_group = true
}

/*
  Devices can use X.509 certificates to connect to AWS IoT Core using TLS mutual authentication protocols.

  The credentials provider authenticates a caller using an X.509 certificate and issues a temporary, limited-privilege
  security token. The token can be used to sign and authenticate any AWS request. This way of authenticating your AWS
  requests requires you to create and configure an AWS Identity and Access Management (IAM) role and attach appropriate
  IAM policies to the role so that the credentials provider can assume the role on your behalf.
*/
resource "aws_iot_certificate" "this" {
  active = true
}

# attach thing to certificate
resource "aws_iot_thing_principal_attachment" "this" {
  principal = "${aws_iot_certificate.this.arn}"
  thing     = "${aws_iot_thing.thing.name}"
}

/*
    Create an IoT Thing Policy

    AWS IoT Core policies allow you to control access to the AWS IoT Core data plane. The AWS IoT Core data
    plane consists of operations that allow you to connect to the AWS IoT Core message broker, send and receive
    MQTT messages, and get or update a thing's Device Shadow.

    Ref: https://docs.aws.amazon.com/iot/latest/developerguide/iot-policies.html
*/
resource "aws_iot_policy" "this" {
  name      = "vkb-policy"
  policy    = jsonencode({
    Version = "2012-10-17",
    Statement = [
      {
        Effect   = "Allow",
        Action   = [
          "iot:Connect",
        ],
        Resource = [
          "arn:aws:iot:::client/${var.client_id}",
        ],
      },
      {
        Effect   = "Allow",
        Action   = [
          "iot:Subscribe",
        ],
        Resource = [
          "arn:aws:iot:::topicfilter/verkundenbot/${var.device_id}/#",
        ],
      },
      {
        Effect   = "Allow",
        Action   = [
          "iot:Publish",
          "iot:Receive",
        ],
        Resource = [
            "arn:aws:iot:::topic/verkundenbot/${var.device_id}/plug1",
            "arn:aws:iot:::topic/verkundenbot/${var.device_id}/plug2",
            "arn:aws:iot:::topic/verkundenbot/${var.device_id}/plug3",
            "arn:aws:iot:::topic/verkundenbot/${var.device_id}/plug4"
        ],
      },
    ],
  })
}

resource "aws_iot_policy_attachment" "thing-policy-attachment" {
  policy = aws_iot_policy.this.name
  target = aws_iot_certificate.this.arn
}







#assume with certificate policy
/*



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
*/