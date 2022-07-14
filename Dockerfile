FROM FROM registry.access.redhat.com/ubi8/openjdk-8:latest

LABEL maintainer = "maddie@gmail.com"

WORKDIR /opt

COPY target/*.jar /opt/spring-dockertutorial

ENTRYPOINT exec java -jar spring-dockertutorial

EXPOSE 8081