import os
import subprocess

def set_wifi_credentials(ssid, password):
    # Backup the current wpa_supplicant.conf file
    subprocess.run(["sudo", "cp", "/etc/wpa_supplicant/wpa_supplicant.conf", "/etc/wpa_supplicant/wpa_supplicant.conf.bak"])

    # Modify wpa_supplicant.conf with the new Wi-Fi credentials
    wifi_config = f'''
network={{
    ssid="{ssid}"
    psk="{password}"
}}
'''
    with open("/etc/wpa_supplicant/wpa_supplicant.conf", "a") as file:
        file.write(wifi_config)

    # Restart the Wi-Fi service to apply the changes
    subprocess.run(["sudo", "wpa_cli", "-i", "wlan0", "reconfigure"])

# Example usage
wifi_ssid = "Your_Wi-Fi_SSID"
wifi_password = "Your_Wi-Fi_Password"

set_wifi_credentials(wifi_ssid, wifi_password)
