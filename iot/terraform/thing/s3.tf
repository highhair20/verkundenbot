
resource "aws_s3_bucket" "thing-deployment-bucket" {
  bucket = "verkundenbot-thing-deployment"
  tags = {
    Name = "verkundenbot-thing-deployment"
  }
}
# Resource to avoid error "AccessControlListNotSupported: The bucket does not allow ACLs"
resource "aws_s3_bucket_ownership_controls" "thing-deployment-bucket" {
  bucket = aws_s3_bucket.thing-deployment-bucket.id

  rule {
    object_ownership = "BucketOwnerPreferred"
  }
}
resource "aws_s3_bucket_acl" "thing-deployment-bucket-acl" {
  bucket = aws_s3_bucket.thing-deployment-bucket.id
  acl    = "private"
  depends_on = [aws_s3_bucket_ownership_controls.thing-deployment-bucket]
}
resource "aws_s3_bucket_versioning" "thing-deployment-bucket-version" {
  bucket = aws_s3_bucket.thing-deployment-bucket.id
  versioning_configuration {
    status = "Enabled"
  }
}

resource "aws_s3_bucket" "thing-shadow-bucket" {
  bucket = "verkundenbot-thing-shadow"
  tags = {
    Name = "verkundenbot-thing-shadow"
  }
}
# Resource to avoid error "AccessControlListNotSupported: The bucket does not allow ACLs"
resource "aws_s3_bucket_ownership_controls" "thing-shadow-bucket" {
  bucket = aws_s3_bucket.thing-shadow-bucket.id

  rule {
    object_ownership = "BucketOwnerPreferred"
  }
}
resource "aws_s3_bucket_acl" "thing-shadow-bucket-acl" {
  bucket = aws_s3_bucket.thing-shadow-bucket.id
  acl    = "private"
  depends_on = [aws_s3_bucket_ownership_controls.thing-shadow-bucket]
}
resource "aws_s3_bucket_versioning" "thing-shadow-bucket-version" {
  bucket = aws_s3_bucket.thing-shadow-bucket.id
  versioning_configuration {
    status = "Enabled"
  }
}
