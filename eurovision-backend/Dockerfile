# Use a base image with Java 17
FROM openjdk:17-oracle

# Copy the JAR package into the image
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} eurovision-backend.jar

# Expose the application port
EXPOSE 8080

# Run the App
ENTRYPOINT ["java", "-server", "-Xmx4096m", "-Xms2048m", "-jar", "/eurovision-backend.jar"]