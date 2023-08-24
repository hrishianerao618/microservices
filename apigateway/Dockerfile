# Use a base image
FROM openjdk:17

# Set the working directory
WORKDIR /app

# Copy the built JAR or executable to the container
COPY target/api-gateway-3.1.2.jar api_gateway.jar

# Expose the port that your microservice runs on
EXPOSE 8080

# Run the microservice
ENTRYPOINT ["java", "-jar", "api_gateway.jar"]
