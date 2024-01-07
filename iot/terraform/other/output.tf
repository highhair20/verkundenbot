

locals {
  version = "${formatdate("YYYY-MM-DD-hh-mm-ss", timestamp())}"
}

#save certificate files
resource "local_file" "thing-certificate-cert" {
  content  = "${aws_iot_certificate.thing-certificate.certificate_pem}"
  filename = "${var.outputs_path}/certificate.pem.cert"
}

resource "local_file" "thing-certificate-pub" {
  content  = "${aws_iot_certificate.thing-certificate.public_key}"
  filename = "${var.outputs_path}/public.pem.key"
}

resource "local_file" "thing-certificate-pri" {
  content  = "${aws_iot_certificate.thing-certificate.private_key}"
  filename = "${var.outputs_path}/private.pem.key"
}

resource "local_file" "thing-config" {
  content  = templatefile("${path.module}/thing-conf.json.tpl", {
    DEVICE_ID   = "${var.device_id}"
    THING_GROUP = "${aws_iot_thing_group.this.name}"
    REGION = "${var.aws_region}"
    SERVICE_ROLE_ALIAS = "${aws_iot_role_alias.thing-service-role-alias.alias}"
    DEPLOYMENT_BUCKET = "${aws_s3_bucket.thing-deployment-bucket.bucket}"
    VERSION = "${local.version}"
  })
  filename = "${var.outputs_path}/conf.json"
}

resource "null_resource" "config" {
  provisioner "local-exec" {
    command = <<EOT
python ${path.module}/upload-outputs.py \
              --destinationBucket=${aws_s3_bucket.thing-deployment-bucket.bucket} \
              --sourceDir=${var.outputs_path} \
              --thingGroup=${aws_iot_thing_group.this.name} \
              --version=${local.version}
EOT
  }
}