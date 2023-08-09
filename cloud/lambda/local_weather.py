import requests
import json
from geopy.geocoders import Nominatim

def lambda_handler(event, context):
    # Set the desired temperature and get the postal code from the event
    comfortable_temp = 70
    postalcode = event['postalcode']

    # Get the latitude and longitude coordinates of the current location from the postal code
    geolocator = Nominatim(user_agent="verkundenbot")
    location_info = geolocator.geocode({'postalcode': postalcode})

    if location_info is None:
        return {
            "statusCode": 400,
            "body": json.dumps("Unable to find location information for the provided postal code.")
        }

    latitude, longitude = location_info.latitude, location_info.longitude

    # Get the weather forecast for the current location
    url = f"https://api.weather.gov/points/{latitude},{longitude}"
    headers = {'User-Agent': "('verkundenbot.com', 'info@verkundenbot.com')"}
    response = requests.get(url, headers=headers)
    weather_data = response.json()

    response = requests.get(weather_data['properties']['forecast'], headers=headers)
    forecast = response.json()

    # Parse the current weather data
    temperature = forecast["properties"]["periods"][0]["temperature"]

    # Decide whether to turn the fan ON or OFF based on the temperature
    fan_status = "ON" if temperature > comfortable_temp else "OFF"

    # Output the current weather data and fan status
    result = {
        "Current_Temperature": temperature,
        "Fan_Status": fan_status
    }

    return {
        "statusCode": 200,
        "body": json.dumps(result)
    }