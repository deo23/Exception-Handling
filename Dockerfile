# Use the official OpenJDK 17 base image
FROM openjdk:17-alpine

# Set the working directory
WORKDIR /app

# Copy your Spring Boot application's JAR file into the container
COPY target/A1-1.0-EXCEPTION-HANDLING.jar /app/app.jar

# Expose the port your Spring Boot application listens on (replace 8080 with your application's port)
EXPOSE 8080

# Specify the command to run your Spring Boot application
CMD ["java", "-jar", "app.jar"]

