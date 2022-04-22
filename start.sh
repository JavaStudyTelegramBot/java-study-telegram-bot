#!/bin/bash

# Pull new changes
git pull

# Prepare Jar
mvn clean
mvn package

# Ensure, that docker-compose stopped
docker-compose stop

# Add environment variables
export BOT_NAME='test_java_study_bot'
export BOT_TOKEN='5341917446:AAHoTpi8cj6gKZmRuNX42-VJbdmP-jofwFE'

# Start new deployment
docker-compose up --build -d