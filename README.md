# Spring Boot Greet app

Minimalistic sample for exploring openshift, k8n etc deployments

```
# JIB
mvn clean package jib:build -Pjib -DskipTests 
```


```
# JKube Openshift
mvn clean package oc:resource oc:build oc:deploy -Pjkube -DskipTests 
```