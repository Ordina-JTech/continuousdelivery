# continuousdelivery
Continuous Delivery

## Varant prerequisites
1. Virtualbox installed (>= 4.3.12)
1. Vagrant installed (>= 1.7.2)

 
## CoreOS Cluster (single node)
1. Clone the repo
1. change directory to vagrant
1. vagrant up
1. vagrant ssh

## Run jenkins
1. build the docker image
 ```
 cd dockerfiles/jenkins
 docker build  -t ordina-cd/jenkins .
 ```

2. Start a docker container by using the custom jenkins image
 ```
 docker run -p 8080:8080 --name jenkins ordina-cd/jenkins
 ```
