FROM openjdk:8-jdk-alpine
LABEL maintainer="raf4352@protonmail.ch"
VOLUME /tmp
EXPOSE 18888
ARG JAR_FILE=target/config-server-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} config-server.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Xmx32m","-Xss256k","-jar","/config-server.jar"]