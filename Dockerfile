FROM openjdk:17-jdk
ARG JAR_FILE=build/libs/*.jar
ADD ${JAR_FILE} nshop.jar
ENTRYPOINT ["java","-jar","/nshop.jar"]