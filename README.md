# This is the VPS setting up setup for debian system.
![ABC GOOasla aadasldlasd](https://img.shields.io/badge/license-MIT-blue.svg?style=flat-square)
### 1. 安装所有必要的软件(如果未安装)
```base
apt update && apt install -y curl mlocate unzip zip gzip fuse
```
### 2. 安装 SSR
```base
wget https://raw.githubusercontent.com/vanyouseea/hlh/master/shadowsocks-all.sh && bash shadowsocks-all.sh
```
### 3. 安装 加速器
```base
wget https://raw.githubusercontent.com/vanyouseea/hlh/master/tcp.sh && bash tcp.sh
```
### 4. 安装aria2
```base
wget https://raw.githubusercontent.com/vanyouseea/hlh/master/aria2.sh && bash aria2.sh
```
### 5. 将.aria2目录下的文件下载下来覆盖原来HOME目录的.aria2里面的文件，通过脚本重启aria2

### 6. 下载tomcat7.zip 和 jdk8.zip
```bash
  wget https://github.com/vanyouseea/hlh/raw/master/tomcat7.zip
  wget https://github.com/vanyouseea/hlh/raw/master/jdk8.zip.001
  ...
  wget https://github.com/vanyouseea/hlh/raw/master/jdk8.zip.008
  
  #合并zip
  cat jdk8.zip* > jdk8.zip，
  #解压到/usr/local/下,tomcat7已经集成了aria2 web
  unzip jdk8.zip
  #在/etc/profile最后加上如下配置
  export JAVA_HOME=/usr/local/java/jdk1.8.0_241
  export PATH=$JAVA_HOME/bin:$PATH
  export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
  export JRE_HOME=$JAVA_HOME/jre
```
### 7. 安装rclone(通过网页找最新的url)，之后将将.config目录下的文件下载下来覆盖原来HOME目录的.config里面的文件
这样就完成了对于OD的挂载,以下的别名命令是挂载OD到VPS和启动关闭tomcat的快捷方式，配置到$HOME/.profile中
```bash
  alias od="nohup /usr/bin/rclone mount hqr:vps /onedrive --copy-links --no-gzip-encoding --no-check-certificate --allow-other --allow-non-empty --umask 000 &"
  alias start="/usr/local/tomcat7/bin/startup.sh"
  alias stop="/usr/local/tomcat7/bin/shutdown.sh"
```
### 8. 将upload.sh下载到$HOME/下，修改权限为755，这样aria2下载完成后自动上传文件到OD

### 9. 大功告成

--- 
# 可选

### e5.sh         e5续订脚本，需要配合crontab一起使用
包含的API调用包括

* 列出邮件

* 获取driveid

* 获取od某目录下的top5文件

* 搜索od文件

* 上传文件到od

* 以itemID的形式获取文件信息

* 删除文件

### banIPs.sh     
ban掉所有连接VPS失败的IP，可以选择ban port或者IP(特别注意别因为自己登录失败而ban了自己)
### e5study.txt   
e5 resful API 学习文档
### soapui-e5.xml 
call e5 resful API via soapUI

### 注册应用
https://login.microsoftonline.com/common/oauth2/v2.0/authorize?client_id=e381aebb-dbbf-4a6f-a9c2-34ebfbdf9424&response_type=code&scope=Files.ReadWrite.All%20Files.ReadWrite.AppFolder%20Files.ReadWrite.Selected%20Mail.ReadWrite%20Mail.Send%20offline_access%20Sites.Read.All%20User.Read&redirect_uri=http://localhost:12345

