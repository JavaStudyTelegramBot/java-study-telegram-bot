FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=java_study_telegram_bot
ENV BOT_TOKEN=5333281252:AAHb7o3FBsxqSEvs5nddUgMSoboS5OuxpBM
ENV BOT_DB_USERNAME=jstb_db_user
ENV BOT_DB_PASSWORD=jstb_db_password
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dspring.datasource.password=${BOT_DB_PASSWORD}", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-Dspring.datasource.username=${BOT_DB_USERNAME}", "-jar","app.jar"]