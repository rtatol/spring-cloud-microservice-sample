FROM openjdk:8-jdk-alpine
LABEL maintainer="raf4352@protonmail.ch"
VOLUME /tmp
EXPOSE 10000
ARG JAR_FILE=target/registration-service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} registration-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/registration-service.jar"]