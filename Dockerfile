FROM openjdk:17-jdk-slim
ARG JAR_FILE=build/libs/*.jar
WORKDIR /app
COPY ${JAR_FILE} /app/string-reply-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/app/string-reply-0.0.1-SNAPSHOT.jar"]