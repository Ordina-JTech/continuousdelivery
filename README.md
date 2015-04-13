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
docker run -p 8080:8080 --name jenkins ordina-cd/jenkins
```