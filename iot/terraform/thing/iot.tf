



/*

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


*/



















/*
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



*/
