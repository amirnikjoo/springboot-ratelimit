FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/sample-0.0.1.jar /app/sample-0.0.1.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "sample-0.0.1.jar"]
