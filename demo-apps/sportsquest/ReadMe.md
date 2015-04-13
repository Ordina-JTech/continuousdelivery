SportsQuest
===========

SportsQuest is a webapp for demo purposes.


Installations
-------------
- Java jdk 8 http://www.oracle.com/technetwork/java/javase/downloads/index.html
- Git http://git-scm.com/downloads
- Apache Tomcat version 8 https://tomcat.apache.org/

Build
--------------
With the commands below you can build the SportsQuest webapp from source. Gradle will be downloaded and installed automatically.
```sh
git clone https://<username>@sportsquest.codecorner.nl/git/sportsquest.git
cd sportsquest
./gradlew build      (or in case of Windows:  gradlew build)
```

Run on application server
------------------------
- Deploy war to Tomcat: build/libs/sportsquest-web-x.x.x.war
- Open in a browser http://http://localhost:8080/sportsquest-web
