# Use a base image
FROM openjdk:17

# Set the working directory
WORKDIR /app

# Copy the built JAR or executable to the container
COPY target/movie.jar app.jar

# Expose the port that your microservice runs on
EXPOSE 8082

# Run the microservice
ENTRYPOINT ["java", "-jar", "app.jar"]
