DESCRIPTION = "Freescale Image - Adds Qt5"
LICENSE = "MIT"
inherit populate_sdk_qt5

require recipes-fsl/images/fsl-image-qt5-validation-imx.bb

IMAGE_FEATURES += "package-management ssh-server-dropbear "

IMAGE_INSTALL += " \
    imx-kobs \
    tslib \
    tslib-calibrate \
    tslib-conf \
    tslib-tests \
    memtester \
    bzip2 \
    gzip \
    canutils \
    dosfstools \
    mtd-utils \
    mtd-utils-ubifs \
    ntpdate \
    vlan \
    tar \
    net-tools \
    ethtool \
    evtest \
    i2c-tools \
    iperf3 \
    iproute2 \
    udev-extraconf \
    openssl \
    v4l-utils \
    alsa-utils \
    sqlite3 \
    libmodbus \
    dbus \
    hostapd \ 
    iptables \
    vsftpd \ 
    rtl8188eu-driver \
    myir-rc-local-qt"
