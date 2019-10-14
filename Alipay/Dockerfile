# This my first nginx Dockerfile
# Version 1.0

# Base images 基础镜像
FROM jdk:8

#VOLUME：定义匿名卷
VOLUME /tmp

#MAINTAINER 维护者信息
#MAINTAINER tianfeiyu

#ENV 设置环境变量
#ENV PATH /usr/local/nginx/sbin:$PATH

#ADD  文件放在当前目录下，拷过去会自动解压
ADD target/demo-0.0.1-SNAPSHOT.jar app.jar
#ADD nginx-1.8.0.tar.gz /usr/local/
#ADD epel-release-latest-7.noarch.rpm /usr/local/

#RUN 执行以下命令
RUN sh -c 'app.jar'
#RUN rpm -ivh /usr/local/epel-release-latest-7.noarch.rpm
#RUN yum install -y wget lftp gcc gcc-c++ make openssl-devel pcre-devel pcre && yum clean all
#RUN useradd -s /sbin/nologin -M www

#WORKDIR 相当于cd
#WORKDIR /usr/local/nginx-1.8.0
#RUN ./configure --prefix=/usr/local/nginx --user=www --group=www --with-http_ssl_module --with-pcre && make && make install
#RUN echo "daemon off;" >> /etc/nginx.conf

#EXPOSE 映射端口
EXPOSE 8080

#CMD 运行以下命令
#CMD ["nginx"]