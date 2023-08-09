import os
import time
import json
import boto3
from AWSIoTPythonSDK.MQTTLib import AWSIoTMQTTClient

# AWS IoT Core configuration
endpoint = "your-iot-endpoint.amazonaws.com"  # Replace with your AWS IoT endpoint
root_ca_path = "path/to/your/root-CA.crt"      # Replace with the path to your root CA certificate

# List of plug configurations (one for each plug)
plug_configurations = [
    {
        "client_id": "plug1",
        "private_key_path": "path/to/your/private_key1.pem",
        "certificate_path": "path/to/your/certificate1.pem",
        "topic": "plug1/topic",
    },
    {
        "client_id": "plug2",
        "private_key_path": "path/to/your/private_key2.pem",
        "certificate_path": "path/to/your/certificate2.pem",
        "topic": "plug2/topic",
    },
    # Add more plug configurations here (up to plug4)
]

# Custom MQTT message callback
def custom_callback(client, userdata, message):
    print(f"Received a new message: {message.payload}")
    # Add your custom logic here to process the received message

# Create MQTT clients and connect to AWS IoT Core
mqtt_clients = []
for config in plug_configurations:
    mqtt_client = AWSIoTMQTTClient(config["client_id"])
    mqtt_client.configureEndpoint(endpoint, 8883)
    mqtt_client.configureCredentials(root_ca_path, config["private_key_path"], config["certificate_path"])
    mqtt_client.configureAutoReconnectBackoffTime(1, 32, 20)
    mqtt_client.configureOfflinePublishQueueing(-1)  # Infinite offline Publish queueing
    mqtt_client.configureDrainingFrequency(2)  # Draining: 2 Hz
    mqtt_client.configureConnectDisconnectTimeout(10)  # 10 seconds
    mqtt_client.configureMQTTOperationTimeout(5)  # 5 seconds

    # Connect to AWS IoT Core
    mqtt_client.connect()

    # Subscribe to the topic for each plug to receive commands
    mqtt_client.subscribe(config["topic"], 1, custom_callback)

    mqtt_clients.append(mqtt_client)

# Main loop to publish data for each plug
while True:
    for idx, mqtt_client in enumerate(mqtt_clients):
        # Replace the following with your smart plug's data for each plug
        smartplug_data = {
            "status": "on",  # Replace with the current status of the smart plug (e.g., on/off)
            "energy": 100.5,  # Replace with the current energy consumption value
        }

        # Convert data to JSON format
        payload = json.dumps(smartplug_data)

        # Publish the data to the corresponding topic for each plug
        mqtt_client.publish(plug_configurations[idx]["topic"], payload, 1)

    # Wait for some time before publishing the next data (adjust as needed)
    time.sleep(5)

# Disconnect from AWS IoT Core when the loop is stopped (not reached in this example)
for mqtt_client in mqtt_clients:
    mqtt_client.disconnect()
