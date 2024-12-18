FROM maven:3.8.8-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml ./ 
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean install -DskipTests

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/bootcamp-product-type-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8030
ENTRYPOINT ["java", "-jar", "app.jar"]