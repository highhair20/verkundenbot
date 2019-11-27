# verkundenbot-cloud
Verkundenbot Java Spring boot API that runs in the AWS cloud and publishes messages to SQS so that they are available for any reveivers.

The REST API is public facing and is used by web hooks (like Datadog) to change state.  The API is also called by the verkundenbot-site to identify current states of verkundenbot-device and to trigger state changes. Suported calls are POST, PUT and GET.

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
