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
    iputils \
    udev-extraconf \
    iperf \
    openssl \
    v4l-utils \
    alsa-utils \
    ppp \
    ppp-quectel \
    sqlite3 \
    libmodbus \
    libxml2 \
    dbus \
    openobex \
    python-lxml \
    python-certifi \
    python-simplejson \
    python-singledispatch \
    python-backports-abc \
    python-pyconnman \
    python-tornado \
    web-demo \
    qt-demo \
    hostapd \ 
    iptables \
    vsftpd \ 
    tinyalsa \
    wifi-bt-conf\ 
    initscript-telnetd  \
    ${@base_contains("MACHINE", "mys6ull14x14", "rtl8188eu-driver", "", d)} \
    myir-rc-local-qt"
