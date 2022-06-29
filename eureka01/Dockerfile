FROM openjdk:11.0.15-jre
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
WORKDIR /
ENTRYPOINT ["java","-jar","/app.jar"]