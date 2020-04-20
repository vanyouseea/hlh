This is the VPS setting up setup for debian system.

1. 安装所有必要的软件(如果未安装)
apt update
apt install curl mlocate unzip zip gzip gunzip fuse

2. 安装 SSR
wget https://raw.githubusercontent.com/vanyouseea/hlh/master/ssr.sh && bash ssr.sh

3. 安装 加速器
wget https://raw.githubusercontent.com/vanyouseea/hlh/master/tcp.sh && bash tcp.sh

4. 安装aria2
wget https://raw.githubusercontent.com/vanyouseea/hlh/master/aria2.sh && bash aria2.sh

5. 将.aria2目录下的文件下载下来覆盖原来HOME目录的.aria2里面的文件，通过脚本重启aria2

6. 下载tomcat7.zip 和 jdk8.zip

https://github.com/vanyouseea/hlh/raw/master/tomcat7.zip

https://github.com/vanyouseea/hlh/raw/master/jdk8.zip

将他们解压到/usr/local/下，tomcat7 已经集成了aria2 web，在/etc/profile最后加上如下配置
  export JAVA_HOME=/usr/local/java/jdk1.8.0_241

  export PATH=$JAVA_HOME/bin:$PATH

  export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar

  export JRE_HOME=$JAVA_HOME/jre

7. 安装rclone(通过网页找最新的url)，之后将将.config目录下的文件下载下来覆盖原来HOME目录的.config里面的文件
这样就完成了对于OD的挂载,以下的别名命令是挂载OD到VPS和启动关闭tomcat的快捷方式，配置到$HOME/.profile中
alias od="nohup /usr/bin/rclone mount hqr:vps /onedrive --copy-links --no-gzip-encoding --no-check-certificate --allow-other --allow-non-empty --umask 000 &"

alias start="/usr/local/tomcat7/bin/startup.sh"

alias stop="/usr/local/tomcat7/bin/shutdown.sh"

8. 将upload.sh下载到$HOME/下，修改权限为755，这样aria2下载完成后自动上传文件到OD

9. 大功告成

=====================================可选=====================================

e5.sh         e5续订脚本，需要配合crontab一起使用

banIPs.sh     ban掉所有连接VPS失败的IP，可以选择ban port或者IP(特别注意别因为自己登录失败而ban了自己)

