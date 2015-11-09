# Convenient script for copying all Jenkins configs to one location.

echo Copying Jenkins configuration files to share/tmp 

cp -r docker/volumes/jenkins/var/jenkins_home/config.xml share/tmp/docker/volumes/jenkins/var/jenkins_home/
find docker/volumes/jenkins/var/jenkins_home/jobs -name 'config.xml' -exec cp --parents \{\} share/tmp \;