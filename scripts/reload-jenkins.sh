#!/bin/bash

systemctl stop jenkins
docker pull jtechnologies/continuousdelivery-jenkins
systemctl start jenkins