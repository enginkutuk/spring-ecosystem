# Build stage
FROM maven:3.8.1-openjdk-17-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

# Package stage
FROM openjdk:17-oracle
COPY --from=build /home/app/target/hello-service*.jar /usr/local/lib/hello-service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/hello-service.jar"]