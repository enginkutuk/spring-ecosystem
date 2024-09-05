# Build stage
FROM maven:3.8.1-openjdk-17-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

# Package stage
FROM openjdk:17-oracle
COPY --from=build /home/app/target/api-gateway*.jar /usr/local/lib/api-gateway.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/usr/local/lib/api-gateway.jar"]