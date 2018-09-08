#/bin/bash

source /etc/wifi-conf/enable-wifi-bt.sh

ifconfig wlan0 up
kill_wpa_fun
sleep 1
wpa_supplicant -D wext -B -i wlan0 -c /etc/wifi-conf/WIFI.CONF

