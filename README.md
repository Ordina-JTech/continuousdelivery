# continuousdelivery
Continuous Delivery

## Varant prerequisites
1. Virtualbox installed (>= 4.3.12)
1. Vagrant installed (>= 1.7.2)

 
## CoreOS Cluster (single node)
1. Clone the repo
1. change directory to vagrant
1. vagrant up

## Run Jenkins
Jenkins should start by itself since it has got a unit file configured within CoreOS. If it does not, execute the following command:
```
vagrant ssh
docker run --rm --name jenkins -p 8080:8080 -p 50000:50000 --privileged=true ordina-cd/jenkins
```

### Upgrade after Dockerfile change
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
