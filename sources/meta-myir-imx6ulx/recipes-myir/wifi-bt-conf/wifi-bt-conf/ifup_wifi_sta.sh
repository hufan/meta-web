#/bin/sh

ifconfig wlan0 up

killall wpa_supplicant
sleep 1
wpa_supplicant -D wext -B -i wlan0 -c /etc/wifi-conf/WIFI.CONF

