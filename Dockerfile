# Stage 1: Build with Maven and OpenJDK 21
FROM maven:3.9.2-openjdk-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run with OpenJDK 21
FROM openjdk:21-jre
WORKDIR /app
COPY --from=build /app/target/scheduled-reports-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
