rebuild:
	docker-compose down
	docker-compose up --build

jib-image:
	echo "Building Docker image..."
	mvn package jib:build -Pjib -Pgit-info -DskipTests

openshift:
	echo "Deploying to Openshift..."
	oc status
	mvn clean package oc:resource oc:build oc:deploy -Pjkube -Pgit-info -DskipTests