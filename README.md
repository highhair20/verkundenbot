# verkundenbot-cloud
Verkundenbot Java Spring boot API that runs in the AWS cloud and publishes messages to SQS so that they are available for any reveivers.

## Endpoints include the following
* POST /alert/pixel-alarm
    * saves event to RDS
    * publishes event to SQS
* POST /alert/free-speach
    * saves event to RDS
    * publishes event to SQS
* PUT /node/{id}
    * saves event to RDS
    * publishes event to SQS
* GET /node/{id}
    * saves event to RDS
    * publishes event to SQS
