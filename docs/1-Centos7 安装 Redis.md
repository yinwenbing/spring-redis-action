## 安装

### 安装gcc依赖

由于Redis是使用C语言开发，依赖gcc，安装前先查看是否安装了gcc

```shell
gcc -v
```

如果没有安装，使用如下命令进行安装

```shell
yum -y install gcc
```

### 下载安装包

```shell
wget http://download.redis.io/releases/redis-5.0.3.tar.gz
```

### 解压缩

使用如下命令，创建`/usr/local/redis`目录

```shell
mkdir -p /usr/local/redis
```

使用如下命令，将安装包解压至`/usr/local/redis`目录

```shell
tar -zxvf redis-stable.tar.gz -C /usr/local/redis/
```

### 编译

```shell
// 进入redis目录
cd /usr/local/redis/redis-5.0.3/
// 编译
make
// 编译测试
make test
// 安装并指定安装目录
make install PREFIX=/usr/local/redis
```

### 启动

* 前台启动

```shell
cd /usr/local/redis/bin/
./redis-server
```

* 后台启动

将源码目录`redis-5.0.3`中的配置文件`redis-conf`复制到Redis安装目录

```shell
cp /usr/local/redis/redis-5.0.3/redis.conf /usr/local/redis/bin/
```

修改Redis安装目录中的配置文件，将`daemonize no`改为`daemonize yes`

```shell
vi redis.conf
```

后台启动

```shell
./redis-server redis.conf
```

查看后台进程

```shell
[root@localhost bin]# netstat -lnp|grep 6379
tcp        0      0 127.0.0.1:6379          0.0.0.0:*               LISTEN      78680/./redis-serve
```

关闭

```
cd /usr/local/redis/bin
./redis-cli
SHOTDUWN
```

### 远程访问

修改配置

```
cd /usr/local/redis/bin
vim redis.conf
```

```
protected-mode no # 该配置项表示是否开启保护模式，默认是开启，开启后 Redis 只能本地进行访问，拒绝外部访问
#bin127.0.0.1 # 表示指定 redis 只接收来自于该 IP 地址的请求，注释掉后，则表示将处理所有请求
```

开放端口

```
firewall-cmd --permanent --zone=public --add-port=6379/tcp
// 重启防火墙
systemctl restart firewalld
// 查看开放端口
netstat -ntl
```


