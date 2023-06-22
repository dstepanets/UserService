FROM amazoncorretto:11

WORKDIR /app

COPY target/*.jar user-service.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/user-service.jar"]
