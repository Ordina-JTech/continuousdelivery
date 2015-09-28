$new_discovery_url='https://discovery.etcd.io/new'

# To automatically replace the discovery token on 'vagrant up', uncomment
# the lines below:
#
if File.exists?('user-data') && ARGV[0].eql?('up')
  require 'open-uri'
  require 'yaml'
 
  token = open($new_discovery_url).read
 
  data = YAML.load(IO.readlines('user-data')[1..-1].join)
  data['coreos']['etcd']['discovery'] = token
 
  yaml = YAML.dump(data)
  File.open('user-data', 'w') { |file| file.write("#cloud-config\n\n#{yaml}") }
end


#
# coreos-vagrant is configured through a series of configuration
# options (global ruby variables) which are detailed below. To modify
# these options, first copy this file to "config.rb". Then simply
# uncomment the necessary lines, leaving the $, and replace everything
# after the equals sign..

# Size of the CoreOS cluster created by Vagrant
$num_instances=1

# Change basename of the VM
# The default value is "core", which results in VMs named starting with
# "core-01" through to "core-${num_instances}".
$instance_name_prefix="core"

# Official CoreOS channel from which updates should be downloaded
$update_channel='stable'

# Log the serial consoles of CoreOS VMs to log/
# Enable by setting value to true, disable with false
# WARNING: Serial logging is known to result in extremely high CPU usage with
# VirtualBox, so should only be used in debugging situations
#$enable_serial_logging=false

# Enable port forwarding of Docker TCP socket
# Set to the TCP port you want exposed on the *host* machine, default is 2375
# If 2375 is used, Vagrant will auto-increment (e.g. in the case of $num_instances > 1)
# You can then use the docker tool locally by setting the following env var:
#   export DOCKER_HOST='tcp://127.0.0.1:2375'
$expose_docker_tcp=2375

# Enable NFS sharing of your home directory ($HOME) to CoreOS
# It will be mounted at the same path in the VM as on the host.
# Example: /Users/foobar -> /Users/foobar
$share_home=false

# Customize VMs
#$vm_gui = false
#$vm_memory = 1024
#$vm_cpus = 1

# Share additional folders to the CoreOS VMs
# For example,
# $shared_folders = {'/path/on/host' => '/path/on/guest', '/home/foo/app' => '/app'}
# or, to map host folders to guest folders of the same name,
# $shared_folders = Hash[*['/home/foo/app1', '/home/foo/app2'].map{|d| [d, d]}.flatten]
$shared_folders = {'../docker' => '/home/core/docker'}

# Docker images to pull (Makes pulling occur during provisioning rather then first service start (which is invisible for the user).
$docker_pull_images = [
    'sonatype/nexus:2.11.3-01',
    'tomcat:jre8',
    'sonarqube:5.1.1',
    'caltha/protractor:latest',
    'jtechnologies/continuousdelivery-jenkins:latest'
]

# Docker images to build
#$docker_buildable_images = {
#    'ordina-cd/jenkins'     => '/home/core/docker/images/jenkins/'
#}

# Enable port forwarding from guest(s) to host machine, syntax is: { 80 => 8080 }, auto correction is enabled by default.
$forwarded_ports = {
    4440 => 4440, # Rundeck
    4444 => 4444, # Protractor Webdriver
    8080 => 8080, # Jenkins
    8081 => 8081, # Nexus
    8888 => 8888, # SportsQuest DEV/TEST
    9000 => 9000, # SonarQube
    9092 => 9092, # SonarQube
    9999 => 9999  # SportsQuest PROD
}
