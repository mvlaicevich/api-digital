# Start with a base image containing Java runtime
FROM maven:3.8.1-openjdk-17-slim AS build

# The application's .jar file
ARG JAR_FILE=target/*.jar

# cd into the app directory
WORKDIR /usr/src/app

# Copy the application's source code from the source directory
# and build the application
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Specifies a base image from the Java Development Kit (JDK)
FROM amazoncorretto:17

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's .jar file
ARG JAR_FILE=target/*.jar

# Add the application's .jar to the container
COPY --from=build /usr/src/app/${JAR_FILE} app.jar

# Run the .jar file
ENTRYPOINT ["java","-jar","/app.jar"]