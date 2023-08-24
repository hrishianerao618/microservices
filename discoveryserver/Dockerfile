# Use a base image
FROM openjdk:17

# Set the working directory
WORKDIR /app

# Copy the built JAR or executable to the container
COPY target/discoveryserver-3.1.2.jar discoveryserver.jar

# Expose the port that your microservice runs on
EXPOSE 8761

# Run the microservice
ENTRYPOINT ["java", "-jar", "discoveryserver.jar"]
