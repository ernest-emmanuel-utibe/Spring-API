##FROM maven:3.8.5-openjdk-17 AS build
##COPY ../.. .
##RUN mvn clean package -DskipTests
##
##FROM openjdk:17.0.1-jdk-slim
##COPY --from=build /target/springapi-0.0.1-SNAPSHOT.jar springapi.jar
##EXPOSE 8080
##ENTRYPOINT ["java", "-jar", "springapi.jar"]
#
## Use the official OpenJDK base image for Java 11
#FROM openjdk:17.0.1-jdk-slim
#
## Set the working directory inside the container
#WORKDIR /app
#
## Copy the Spring Boot application JAR file into the container
#COPY target/springapi-0.0.1-SNAPSHOT.jar /app/springapi.jar
##COPY springapi-0.0.1-SNAPSHOT.jar /app/springapi.jar
#
## Expose the port your application will run on
#EXPOSE 8080
#
## Command to run the application
#CMD ["java", "-jar", "springapi.jar"]


# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory to /app
WORKDIR /app

# Copy the application JAR file into the container at /app
COPY target/springapi-0.0.1-SNAPSHOT.jar .

# Run the application when the container launches
CMD ["java", "-jar", "springapi.jar"]

