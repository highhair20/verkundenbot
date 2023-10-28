
resource "aws_s3_bucket" "thing-deployment-bucket" {
  bucket = "verkundenbot-thing-deployment-${aws_iot_thing_group.this.name}-${var.aws_region}"
  tags = {
    Name = "verkundenbot-thing-deployment-${aws_iot_thing_group.this.name}-${var.aws_region}"
  }
}
resource "aws_s3_bucket_acl" "thing-deployment-bucket-acl" {
  bucket = aws_s3_bucket.thing-deployment-bucket.id
  acl    = "private"
  depends_on = [aws_s3_bucket_ownership_controls.s3_bucket_acl_ownership]
}
# Resource to avoid error "AccessControlListNotSupported: The bucket does not allow ACLs"
resource "aws_s3_bucket_ownership_controls" "s3_bucket_acl_ownership" {
  bucket = aws_s3_bucket.thing-deployment-bucket.id
  rule {
    object_ownership = "ObjectWriter"
  }
}
resource "aws_s3_bucket_versioning" "thing-deployment-bucket-versioning" {
  bucket = aws_s3_bucket.thing-deployment-bucket.id
  versioning_configuration {
    status = "Enabled"
  }
}

resource "aws_s3_bucket" "thing-shadow-bucket" {
  bucket = "verkundenbot-thing-shadow-${var.aws_region}"
  tags = {
    Name = "verkundenbot-thing-shadow-${var.aws_region}"
  }
}

resource "aws_s3_bucket_acl" "thing-shadow-bucket-acl" {
  bucket = aws_s3_bucket.thing-shadow-bucket.id
  acl    = "private"
}

resource "aws_s3_bucket_versioning" "thing-shadow-bucket-versioning" {
  bucket = aws_s3_bucket.thing-shadow-bucket.id
  versioning_configuration {
    status = "Enabled"
  }
}

resource "aws_glue_catalog_database" "thing-shadow-database" {
  name = "verkundenbot_thing_shadow_database"
}

resource "aws_glue_catalog_table" "thing-shadow-table" {
  name          = "verkundenbot_thing_shadow_table"
  database_name = "${aws_glue_catalog_database.thing-shadow-database.name}"

  table_type = "EXTERNAL_TABLE"

  storage_descriptor {
    location      = "s3://${aws_s3_bucket.thing-shadow-bucket.bucket}/things/shadow/"
    input_format  = "org.apache.hadoop.mapred.TextInputFormat"
    output_format = "org.apache.hadoop.hive.ql.io.IgnoreKeyTextOutputFormat"

    ser_de_info {
      serialization_library = "org.openx.data.jsonserde.JsonSerDe"
      name= "thing_shadow_serde"
    }

    columns {
      name = "thingname"
      type = "string"
    }

    columns {
      name = "logtimestamp"
      type = "timestamp"
    }

    columns {
      name    = "state"
      type    = "struct<reported:struct<onstart:struct<resetreason:string,chipid:int,cpufreqmhz:int,sketchmd5:string,coreversion:string,sdkversion:string,flashchiprealsize:int,flashchipsize:int>,onloop:struct<analogpinoutputvalue:int,analogpina0:int,vcc:double>>>"
    }
  }
}
