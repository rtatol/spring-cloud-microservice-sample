FROM openjdk:8-jdk-alpine
LABEL maintainer="raf4352@protonmail.ch"
VOLUME /tmp
EXPOSE 1-65535
ARG JAR_FILE=target/account-service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} account-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/account-service.jar"]