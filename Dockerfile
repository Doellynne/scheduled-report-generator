# Stage 1: Build with Maven + Eclipse Temurin JDK 21
FROM maven:3.9.2-eclipse-temurin-21-jdk AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run with Eclipse Temurin JDK 21 runtime
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/scheduled-reports-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

