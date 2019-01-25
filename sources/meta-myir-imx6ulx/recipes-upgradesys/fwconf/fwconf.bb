# MYIR - 2018   Alex .

DESCRIPTION = "Extra files for MYiR"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=309cc7bace8769cfabdd34577f654f8e"

SRC_URI = "file://LICENSE \
	   file://fw_env.config \
	   file://hwrevision \
	   file://sw-versions\
          "

S = "${WORKDIR}"

do_install () {
	    install -m 755 ${S}/fw_env.config ${D}/${sysconfdir}
	    install -m 755 ${S}/hwrevision ${D}/${sysconfdir}
	    install -m 755 ${S}/sw-versions ${D}/${sysconfdir}
}

FILES_${PN} = " ${sysconfdir} \
              "
