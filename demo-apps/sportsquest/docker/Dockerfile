FROM tomcat:8-jre8
MAINTAINER Sebastiaan Renkens sebastiaan.renkens@ordina.nl

# Upstream tomcat is expected to EXPOSE port 8080

# Embed the war of the build inside the container
COPY  ../build/libs/sportsquest*.war /usr/local/tomcat/webapps/

CMD ["catalina.sh", "run"]