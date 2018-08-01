FROM openjdk:8-jdk-alpine
LABEL maintainer="raf4352@protonmail.ch"
VOLUME /tmp
EXPOSE 10001
ARG JAR_FILE=target/account-service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} account-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Xmx64m","-Xss256k","-jar","/account-service.jar"]