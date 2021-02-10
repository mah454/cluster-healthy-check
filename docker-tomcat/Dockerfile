FROM store/oracle/serverjre:1.8.0_241-b07
MAINTAINER Mahdi Sheikh Hosseini <mah454>

RUN yum install -y tar gzip
RUN curl "https://downloads.apache.org/tomcat/tomcat-9/v9.0.43/bin/apache-tomcat-9.0.43.tar.gz"  -o /opt/tomcat.tar.gz
RUN tar -xvf /opt/tomcat.tar.gz -C /opt ; \
		mv /opt/apache-tomcat-9.0.43 /opt/tomcat ; \
		ln -s /opt/tomcat /tomcat ; rm /opt/tomcat.tar.gz  ; \
		rm -rf /tomcat/webapps/*

COPY setenv.sh /tomcat/bin
COPY entrypoint.sh /

CMD ["/entrypoint.sh"]
