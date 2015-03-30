#!/bin/bash

#####
# This automates all the prerequisites that are needed to get the vagrant CoreOS cluster running. These include:
#  - Preparing the target folder (Your actual base for running vagrant commands)
#  - Generating a unique CoreOS ClusterID
#  - Preparing vagrant setup

# Prepare the target folder
if [ ! -d target ]; then
  echo Preparing target folder
  mkdir target
else 
 rm target/* -rf
fi

# Setup the cloud config  
echo Preparing etcd cluster discovery id
if [ ! -f target/cloud-config.yaml ]; then
    
	# Request a unique CoreOS ClusterID
	echo Requesting new ClusterID
    CLUSTER_ID=$(curl -sw "\n" https://discovery.etcd.io/new)
    echo "    ClusterID: $CLUSTER_ID"
    cp src/cloud-config.yaml target/cloud-config.yaml
    sed -i  "s/PH_TOKEN/$(echo  $CLUSTER_ID | sed -e 's/\//\\\//g')/g" src/cloud-config.yaml\
	
	# Other tweaks to cloud-config.yaml file
else
    echo Cloud config file exists, no need for an update.
fi

# Setup vagrant
echo Preparing Vagrant
if [ ! -f target/Vagrantfile ]; then
	cp src/Vagrantfile target/Vagrantfile
fi

# Done
echo Please enter the target folder and run vagrant up to start the coreos cluster
echo