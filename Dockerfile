FROM ubuntu:latest
LABEL authors="Dmytro Armianishyn"

WORKDIR /app

ARG Jar_File=target/*.jar

COPY ${Jar_File} app.jar

ENTRYPOINT ["java", "-jar", "/app/*.jar"]