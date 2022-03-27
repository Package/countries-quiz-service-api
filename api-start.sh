#!/bin/bash

# Clean Build
./mvnw clean package -DskipTests

# Copy built JAR
cp target/country-api-0.0.1-SNAPSHOT.jar src/main/docker

# Start Docker
docker-compose -f src/main/docker/docker-compose.yml up -d

echo "API Running at: http://localhost:5000"