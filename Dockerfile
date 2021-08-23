FROM openjdk:8-jdk-alpine
LABEL maintainer="hsb1596321@gmail.com"
VOLUME /tmp
ARG JAR_FILE=./build/libs/*.jar
ADD ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://172.30.1.17/test","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]