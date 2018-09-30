#/bin/bash

source /etc/wifi-conf/basicsh

NET_PATH="/sys/class/net/"
NET_INTERFACE="wlan0"

TEMP_STATE=` cat ${NET_PATH}${NET_INTERFACE}/operstate `
if [ "down" == ${TEMP_STATE} ]; then
	ifconfig ${NET_INTERFACE} up
fi  

PRO_NAME="udhcpc"
kill_process_fun  $PRO_NAME
PRO_NAME="wpa_supplicant"
kill_process_fun  $PRO_NAME

sleep 1
wpa_supplicant -D wext -B -i ${NET_INTERFACE} -c /etc/wifi-conf/WIFI.CONF
sleep 3
udhcpc -i ${NET_INTERFACE} &
