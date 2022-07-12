FROM openjdk:8-slim

LABEL maintainer = "maddie@gmail.com"

WORKDIR /opt

COPY target/*.jar /opt/spring-dockertutorial

ENTRYPOINT exec java -jar spring-dockertutorial

EXPOSE 8081