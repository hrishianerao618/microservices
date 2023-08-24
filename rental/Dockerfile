# Use a base image
FROM openjdk:17

# Set the working directory
WORKDIR /app

# Copy the built JAR or executable to the container
COPY target/rental-0.0.1-SNAPSHOT.jar rental.jar

# Expose the port that your microservice runs on
EXPOSE 8083

# Run the microservice
ENTRYPOINT ["java", "-jar", "rental.jar"]
