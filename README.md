# Continuous Delivery

The aim of this project is to deliver a live demo environment for showing working examples of Continuous Delivery.
It consist of an ecosystem of a CoreOS cluster and a set of Docker images that together provides the following servers:
- Jenkins
- Rundeck
- Nexus
- Tomcat

## Getting Started

### Varant prerequisites
1. Virtualbox installed (>= 4.3.12)
1. Vagrant installed (>= 1.7.2)
 
### CoreOS Cluster (single node)
1. Clone the repo
1. change directory to vagrant
1. vagrant up

### Port numbers and default username's and password
1. localhost:8080 Jenkins --> Username: none password: none
1. localhost:8081 Nexus --> Username:admin password: admin123
1. localhost:4440 Rundeck --> Username: admin password: admin

#### Upgrade after Dockerfile change
By using vagrant:
```
vagrant reload
vagrant provision
```
Or directly inside the coreos machine
```
docker docker build --no-cache=true -t ordina-cd/jenkins /home/core/dockerimages/jenkins/
docker run --rm --name jenkins -p 8080:8080 -p 50000:50000 --privileged=true ordina-cd/jenkins
```
