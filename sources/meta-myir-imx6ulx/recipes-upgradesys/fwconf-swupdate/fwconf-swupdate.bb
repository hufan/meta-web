# MYIR - 2019   Alex .

DESCRIPTION = "Extra files for MYiR"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=26c59bdf3d7afdce38f7f80f53761d12"

SRC_URI = "file://LICENSE \
	   file://fw_env.config \
	   file://hwrevision \
	   file://sw-versions\
          "

S = "${WORKDIR}"

do_install () {
	    install -d ${D}/${sysconfdir}
	    install -m 755 ${S}/fw_env.config ${D}/${sysconfdir}
	    install -m 755 ${S}/hwrevision ${D}/${sysconfdir}
	    install -m 755 ${S}/sw-versions ${D}/${sysconfdir}
}

TARGET_CC_ARCH += "${LDFLAGS}"
INSANE_SKIP_${PN}-dev = "ldflags"
INSANE_SKIP_${PN} = "${ERROR_QA} ${WARN_QA}"
                                             
