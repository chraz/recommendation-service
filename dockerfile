FROM openjdk:17-slim
COPY target/*.jar /home/app/recommendation-service/recommendation-service/recommendation-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/home/app/recommendation-service/recommendation-service/recommendation-service-0.0.1-SNAPSHOT.jar"]
