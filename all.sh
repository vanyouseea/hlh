#!/bin/sh

apt update
echo "安装curl mlocate unzip zip gzip fuse..."
apt update && apt install -y curl mlocate unzip zip gzip fuse
echo "安装完成"

echo "开启BBR"
echo "net.core.default_qdisc=fq" >> /etc/sysctl.conf
echo "net.ipv4.tcp_congestion_control=bbr" >> /etc/sysctl.conf
sysctl -p
sysctl net.ipv4.tcp_available_congestion_control
echo "开启完成"

echo "安装tomcat7..."
wget https://github.com/vanyouseea/hlh/raw/master/tomcat7.zip
mv tomcat7.zip /usr/local/
unzip /usr/local/tomcat7.zip
rm -rf /usr/local/tomcat7.zip
chmod -R 755 /usr/local/tomcat7/
echo "安装完成"

echo "安装Java8..."
wget https://github.com/vanyouseea/hlh/raw/master/jdk8.zip.001
wget https://github.com/vanyouseea/hlh/raw/master/jdk8.zip.002
wget https://github.com/vanyouseea/hlh/raw/master/jdk8.zip.003
wget https://github.com/vanyouseea/hlh/raw/master/jdk8.zip.004
wget https://github.com/vanyouseea/hlh/raw/master/jdk8.zip.005
wget https://github.com/vanyouseea/hlh/raw/master/jdk8.zip.006
wget https://github.com/vanyouseea/hlh/raw/master/jdk8.zip.007
wget https://github.com/vanyouseea/hlh/raw/master/jdk8.zip.008
cat jdk8.zip* > jdk8.zip
rm jdk8.zip.00*
mv jdk8.zip /usr/local/
unzip /usr/local/jdk8.zip
rm -rf /usr/local/jdk8.zip
chmod -R 755 /usr/local/java/
echo "安装完成"

echo "配置tomcat7,jdk快捷键及环境变量"

echo "">>/etc/profile
echo "export JAVA_HOME=/usr/local/java/jdk1.8.0_241">>/etc/profile
echo 'export PATH=$JAVA_HOME/bin:$PATH'>>/etc/profile
echo 'export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar'>>/etc/profile
echo 'export JRE_HOME=$JAVA_HOME/jre'>>/etc/profile
echo "alias ll='ls -ltr'">>/etc/profile
source /etc/profile

echo "">>~/.profile
mkdir /onedrive
echo "alias od='nohup /usr/bin/rclone mount hqr:vps /onedrive --copy-links --no-gzip-encoding --no-check-certificate --allow-other --allow-non-empty --umask 000 &'">>~/.profile
echo "alias start='/usr/local/tomcat7/bin/startup.sh'" >>~/.profile
echo "alias stop='/usr/local/tomcat7/bin/shutdown.sh'" >>~/.profile
source ~/.profile
echo "配置完成"

echo '安装Rclone...'
wget https://rclone.org/install.sh && bash install.sh
echo '安装完成'

echo '安装Aria2'
wget https://raw.githubusercontent.com/vanyouseea/hlh/master/aria2.sh && bash aria2.sh
echo '安装完成'

echo '获取全局配置文件及脚本'
wget https://od.leasr.tk/AllUtil.zip

