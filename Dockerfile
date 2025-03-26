# Use OpenJDK as the base image
FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built JAR file (update the name if needed)
COPY target/*.jar app.jar

# Expose the backend port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
# Use OpenJDK as the base image
