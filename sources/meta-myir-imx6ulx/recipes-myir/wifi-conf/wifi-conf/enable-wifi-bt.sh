#/bin/sh

RFKILL_SYSFS_PTAH="/sys/class/rfkill"
RFKILL_T="rfkill"

kill -9 ` ps -A | grep "wpa_supplicant"| awk '{print $1}' `

if [ -d $RFKILL_SYSFS_PTAH ]; then
	# echo " enable wifi & bt control"
	for i in $(seq 0 4)
	do 
		# echo $(expr $i \* 3 + 1);
		PATH_TEMP=${RFKILL_SYSFS_PTAH}"/"${RFKILL_T}${i}
		if [ -d $PATH_TEMP ]; then
			temp_name=` cat ${RFKILL_SYSFS_PTAH}"/"${RFKILL_T}${i}"/name" `
			echo ${temp_name}
			if [ "phy0" == ${temp_name} ]; then
				echo 1 >  ${PATH_TEMP}"/state"
			elif [ "hci0" == ${temp_name} ]; then
				echo 1 >  ${PATH_TEMP}"/state"
			else
				echo "empty"
			fi 
		fi
	done
fi

kill -9 ` ps -A | grep "wpa_supplicant" | awk '{print $1}' `
