DESCRIPTION = "web dem"
DEPENDS = "zlib glibc ncurses "
SECTION = "libs"
LICENSE = "MIT"
PV = "3"
PR = "r0"

PACKAGES = "${PN}-dbg ${PN} ${PN}-doc ${PN}-dev ${PN}-staticdev ${PN}-locale"
PACKAGES_DYNAMIC = "${PN}-locale-*"


SRCREV = "47a3d6d978bd77495fd876ae53a80aab3acc05ea"
SRC_URI = "  \
            git://github.com/hufan/web-demo-bb;protocol=https;branch=web_server"
			
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

S = "${WORKDIR}/git"

do_compile () {
 tar xvf cJSON.tar.bz2 
 make
}


do_install () {
      install -d ${D}/usr/share/myir/
      install -d ${D}/usr/share/myir/www/
      install -d ${D}/usr/lib/
      install -d ${D}/usr/bin/
      	  
      cp -S ${S}/*.so* ${D}/usr/lib/
      cp -r ${S}/web_server/* ${D}/usr/share/myir/www/

      if [ ${MACHINE} = "myd-y6ul14x14" ]
      then
      install -m 0755 ${S}/board_cfg_mydy6ul.json ${D}/usr/share/myir/board_cfg.json
      install -m 0755 ${S}/board_cfg_mydy6ul.json ${D}/usr/share/board_cfg.json
      elif [ ${MACHINE} = "myd-y6ull14x14" ]
      then
      install -m 0755 ${S}/board_cfg_mydy6ull.json ${D}/usr/share/myir/board_cfg.json
      install -m 0755 ${S}/board_cfg_mydy6ull.json ${D}/usr/share/board_cfg.json
      elif [ ${MACHINE} = "mys6ul14x14" ]
      then
      install -m 0755 ${S}/board_cfg_mysy6ul.json ${D}/usr/share/myir/board_cfg.json
      install -m 0755 ${S}/board_cfg_mysy6ul.json ${D}/usr/share/board_cfg.json
      elif [ ${MACHINE} = "mys6ull14x14" ]
      then
      install -m 0755 ${S}/board_cfg_mysy6ull.json ${D}/usr/share/myir/board_cfg.json
      install -m 0755 ${S}/board_cfg_mysy6ull.json ${D}/usr/share/board_cfg.json
      fi

      install -m 0755 ${S}/mxde.xml ${D}/usr/share/myir/
      install -m 0755 ${S}/settings.ini ${D}/usr/share/myir/
      install -m 0755 ${S}/psplash ${D}/usr/bin/
      install -m 755 ${S}/init_boardcfg.py ${D}/usr/share/myir/
      install -m 755 ${S}/v4l2grab ${D}/usr/bin/
}

FILES_${PN} = "/home/myir/ \
	       /usr/share/myir/ \
	       /usr/share/myir/www/ \
	       /usr/share/myir/www/* \
	       /usr/share/myir/*/* \
	       /usr/lib/ \
	       /usr/bin/ \
             "

TARGET_CC_ARCH += "${LDFLAGS}"
INSANE_SKIP_${PN}-dev = "ldflags"
INSANE_SKIP_${PN} = "${ERROR_QA} ${WARN_QA}"
