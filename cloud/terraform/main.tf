provider "aws" {
  profile = "glolabs"
  region = "us-east-1"
}

# Create an IoT Thing Type
resource "aws_iot_thing_type" "example" {
  name  = "MyIoTThingType"
  properties {
    description = "My IoT Thing Type"
  }
}

# Create an IoT Thing Policy
resource "aws_iot_policy" "example" {
  name        = "MyIoTPolicy"
  policy = jsonencode({
    Version = "2012-10-17",
    Statement = [
      {
        Effect   = "Allow",
        Action   = [
          "iot:Connect",
          "iot:Publish",
          "iot:Subscribe",
          "iot:Receive",
        ],
        Resource = "*",
      },
    ],
  })
}

# Create an IoT Thing
resource "aws_iot_thing" "example" {
  name        = "MyIoTThing"
  thing_type_name = aws_iot_thing_type.example.name
}

resource "aws_iot_certificate" "cert" {
  active = true
}

# Attach the IoT Thing Policy to the IoT Thing
resource "aws_iot_policy_attachment" "example" {
  policy = aws_iot_policy.example.name
  target = aws_iot_certificate.cert.arn
}