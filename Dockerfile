#FROM openjdk:17-jdk-alpine
#ARG JAR_FILE=target/*.jar
#COPY /target/SpringapiApplication-0.0.1.jar app.jar
#ENTRYPOINT ["java", ".jar", "./app.jar"]

#FROM maven:3.8.5-openjdk-17 AS build
#COPY ../.. .
#RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/SpringapiApplication-0.0.1-SNAPSHOT.jar SpringapiApplication.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "SpringapiApplication.jar"]

#FROM maven:3.8.7 as build
#WORKDIR /app
#COPY . .
#RUN mvn package -DskipTests -Dmaven.compiler.source=17 -Dmaven.compiler.target=17

#FROM eclipse-temurin:17
#
#COPY --from=build /app/target/*.jar /app.jar
#
#EXPOSE 8080
#
#CMD ["java", "-jar", "-Dserver.port=8080", "app.jar"]