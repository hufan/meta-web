# Copyright (C) 2013-2016 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux Kernel for MYiR MYS6ULx board"
DESCRIPTION = "Linux Kernel provided and supported by Freescale with focus on \
i.MX Family Reference Boards. It includes support for many IPs such as GPU, VPU and IPU."

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

LOCALVERSION = "-1.2.0"
<<<<<<< HEAD
SRCREV = "2345cf99f3cba35af24e67ce21e5c7d141c029ed"
SRCBRANCH = "mys-6ulx"
=======
SRCREV = "6565527b48a8a5d31d01f97fe86585e6cb10c416"
SRCBRANCH = "myd-y6ulx-hmi"
>>>>>>> 32cd476... add telnetd init script and tinyalsa
SRC_URI = "git:///${HOME}/MYiR-iMX-Linux;protocol=file;branch=${SRCBRANCH} \
           file://defconfig \ 
          "

DEFAULT_PREFERENCE = "1"

COMPATIBLE_MACHINE = "(mx6ull|mx6ul)"
