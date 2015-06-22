# Continuous Delivery

The aim of this project is to deliver a live demo environment for showing working examples of Continuous Delivery.
It consist of an ecosystem of a CoreOS cluster and a set of Docker images that together provides the following servers:

- Jenkins
- Rundeck
- Nexus
- Tomcat

## Getting Started

### Prerequisites
1. Virtualbox installed (>= 4.3.12)
1. Vagrant installed (>= 1.7.2)
 
### Start the CoreOS Cluster (single node)
1. Clone the Git repo
1. change directory to vagrant
1. vagrant up

### Port numbers and default username's and password
- <http://localhost:8080> Jenkins -->  none / none
- <http://localhost:8081> Nexus --> admin / admin123
- <http://localhost:4440> Rundeck --> admin / admin

#### Upgrade after Dockerfile change
By using Vagrant:

	vagrant reload
	vagrant provision

Or directly inside the CoreOS machine:

	docker build --no-cache=true -t ordina-cd/jenkins /home/core/dockerimages/jenkins/
	docker run --rm --name jenkins -p 8080:8080 -p 50000:50000 --privileged=true ordina-cd/jenkins


## Jenkins info
Jenkins contains the docker-build-step plugin and is configured to communicate with the docker host running at the CoreOS machine. The Jenkins container is started with a volume paramter that makes the Docker socket available within the Jenkins container.
