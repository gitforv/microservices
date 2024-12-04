# Stage 1: Build the application using Maven
FROM maven:3.9.9 as builder

WORKDIR /app
COPY . .

# Run Maven to build the application
RUN mvn clean install -DskipTests

# Stage 2: Run the application using JDK 17
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file from the build context to the container
# Assuming the Spring Boot application jar is built and located in the target/ directory
#COPY target/p-service.jar /app/p-service.jar
COPY --from=builder /app/target/p-service.jar /app/p-service.jar

# Expose the port that the Spring Boot application will run on
EXPOSE 8080

# Set the command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/p-service.jar"]