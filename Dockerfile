FROM openjdk:21-jdk
LABEL maintainer="email"
ARG JAR_FILE=build/libs/*.jar
ADD ${JAR_FILE} docker-springboot.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/docker-springboot.jar"]