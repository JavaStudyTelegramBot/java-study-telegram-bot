FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=test_java_study_bot
ENV BOT_TOKEN=5341917446:AAHoTpi8cj6gKZmRuNX42-VJbdmP-jofwFE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-jar","/app.jar"]