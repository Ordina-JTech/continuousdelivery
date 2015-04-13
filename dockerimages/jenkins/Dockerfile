FROM jenkins:latest

USER root

# Jenkins main configuration
COPY  config/config.xml /var/jenkins_home/config.xml
RUN chown jenkins:jenkins /var/jenkins_home/config.xml
RUN chmod 644 /var/jenkins_home/config.xml

# SportQuest job
COPY config/jobs/ /var/jenkins_home/jobs/

# Fix Permissions
RUN chown -R jenkins:jenkins /var/jenkins_home/jobs/

# Jenkins plugins
COPY  plugins.txt /tmp/plugins.txt
RUN /usr/local/bin/plugins.sh /tmp/plugins.txt