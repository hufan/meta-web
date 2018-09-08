#/bin/bash

source /etc/wifi-conf/enable-wifi-bt.sh

ifconfig wlan0 up 192.168.10.1

kill_wpa_fun

sleep 1
udhcpd /etc/wifi-conf/udhcpd.conf &
sleep 1
hostapd -B /etc/wifi-conf/hostapd.conf

