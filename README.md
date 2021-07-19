# Spring Boot Greet app

Mini app for playing with cloud platforms

Image with JIB
```
mvn clean package jib:build -Pjib -DskipTests 
```

Deploy to Openshift with JKube
```
mvn clean package oc:resource oc:build oc:deploy -Pjkube -DskipTests 
```

Start locally
```
docker-compose up
```

Rebuild and Redeploy
```
docker-compose down
docker-compose up --build
```