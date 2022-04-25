#!/bin/bash

# Pull new changes
git pull

# Prepare Jar
mvn clean
docker-compose -f docker-compose-test.yml up -d
mvn package

# Ensure, that docker-compose stopped
docker-compose stop

# Add environment variables
export BOT_NAME=test_java_study_bot
export BOT_TOKEN=5341917446:AAHoTpi8cj6gKZmRuNX42-VJbdmP-jofwFE
export BOT_DB_USERNAME='jstb_db_user'
export BOT_DB_PASSWORD='jstb_db_password'

# Start new deployment
docker-compose up --build -d