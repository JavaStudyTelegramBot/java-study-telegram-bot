FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=test_java_study_bot
ENV BOT_TOKEN=5341917446:AAHoTpi8cj6gKZmRuNX42-VJbdmP-jofwFE
ENV BOT_DB_USERNAME=jstb_db_user
ENV BOT_DB_PASSWORD=jstb_db_password
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dspring.datasource.password=${BOT_DB_PASSWORD}", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-Dspring.datasource.username=${BOT_DB_USERNAME}", "-jar","/app.jar"]