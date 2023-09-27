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
        "serial-number"
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
            "arn:aws:iot:${var.aws_region}:${var.aws_account_id}:topicfilter/verkundenbot/${var.serial_number}/#",
        ],
      },
      {
        Effect   = "Allow",
        Action   = [
          "iot:Publish",
          "iot:Receive",
        ],
        Resource = [
            "arn:aws:iot:${var.aws_region}:${var.aws_account_id}:topic/verkundenbot/${var.serial_number}/plug1",
            "arn:aws:iot:${var.aws_region}:${var.aws_account_id}:topic/verkundenbot/${var.serial_number}/plug2",
            "arn:aws:iot:${var.aws_region}:${var.aws_account_id}:topic/verkundenbot/${var.serial_number}/plug3",
            "arn:aws:iot:${var.aws_region}:${var.aws_account_id}:topic/verkundenbot/${var.serial_number}/plug4"
        ],
      },
    ],
  })
}


# Create an IoT Thing
resource "aws_iot_thing" "this" {
  name        = "VerkundenbotThing-${var.serial_number}"
  attributes    = {
    "model": "0.1",
    "serial-number": "${var.serial_number}"
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