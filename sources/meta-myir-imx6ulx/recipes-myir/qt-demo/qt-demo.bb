DESCRIPTION = "qt app"
DEPENDS = "zlib glibc ncurses "
SECTION = "libs"
LICENSE = "MIT"
PV = "3"
PR = "r0"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRCREV = "b8d9ae6e075f762a33d089b310135ce076b9c56f"
SRC_URI = " \ 
	    git://github.com/hufan/web-demo-bb;protocol=https;branch=qt-app \
          "
S_G = "${WORKDIR}/git"

do_install () {
      install -d ${D}/usr/share/myir/
      install -d ${D}/usr/share/applications/
      install -d ${D}/usr/share/pixmaps/
      install -d ${D}/usr/lib/fonts/
      install -d ${D}/lib/
      install -d ${D}/home/myir/

      cp -r ${S_G}/applications/* ${D}/usr/share/applications/
      cp -r ${S_G}/pixmaps/* ${D}/usr/share/pixmaps/
      cp -r ${S_G}/msyh.ttc ${D}/usr/lib/fonts/
      cp  -rfav ${S_G}/so/*.so*  ${D}/lib/
      cp   ${S_G}/qt-app/*  ${D}/home/myir/

}

FILES_${PN} = "/home/myir/ \
	     /usr/share/myir/ \
	     /usr/lib/fonts/ \
	     /lib/ \
	     /usr/share/applications/ \
	     /usr/share/pixmaps/ \
             "

#For dev packages only
INSANE_SKIP_${PN}-dev = "ldflags"
INSANE_SKIP_${PN} = "${ERROR_QA} ${WARN_QA}"
