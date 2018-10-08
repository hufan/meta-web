# MYIR - 2018   Alex .

DESCRIPTION = "Extra files for MYiR"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=309cc7bace8769cfabdd34577f654f8e"

SRC_URI = "file://hostapd.conf \
	   file://udhcpd.conf \
           file://ifup_wifi_ap \
           file://enable-wifi-bt \
	   file://ifup_wifi_sta.sh \
	   file://update_bt_firmware \
	   file://basicsh \
	   file://WIFI.CONF \
           file://LICENSE \
           "
		   
S = "${WORKDIR}"

do_install () {
        
        install -d ${D}/${sysconfdir}/init.d
        install -d ${D}/usr/bin/
	install -d ${D}/${sysconfdir}/wifi-conf
        
	install -m 755 ${S}/hostapd.conf  ${D}/${sysconfdir}/wifi-conf/
        install -m 755 ${S}/udhcpd.conf  ${D}/${sysconfdir}/wifi-conf/
	
        install -m 755 ${S}/enable-wifi-bt  ${D}/usr/bin/
	install -m 755 ${S}/ifup_wifi_ap  ${D}/${sysconfdir}/wifi-conf/
	install -m 755 ${S}/WIFI.CONF  ${D}/${sysconfdir}/wifi-conf/
	install -m 755 ${S}/basicsh   ${D}/${sysconfdir}/wifi-conf/
	install -m 755 ${S}/update_bt_firmware  ${D}/${sysconfdir}/wifi-conf/
	install -m 755 ${S}/ifup_wifi_sta.sh  ${D}/${sysconfdir}/wifi-conf/
}

FILES_${PN} = " ${sysconfdir}/ \
		${sysconfdir}/wifi-conf \
		/usr/bin/ \
	      "
