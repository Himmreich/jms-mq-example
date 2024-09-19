FROM maven:3.9.8-eclipse-temurin-22 AS build

ADD . /home/project
RUN mvn -f /home/project/pom.xml clean package -DskipTests

FROM eclipse-temurin:23-jre

EXPOSE 8080/tcp

ARG JAR_FILE=/home/project/target/*.jar
COPY --from=build ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar","/app.jar"]
