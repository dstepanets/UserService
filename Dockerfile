FROM maven:3.9-amazoncorretto-11 AS build
ENV HOME=/usr/app
RUN mkdir -p $HOME
WORKDIR $HOME
ADD pom.xml $HOME
RUN mvn verify --fail-never
ADD . $HOME
RUN mvn package

FROM amazoncorretto:11-alpine
COPY --from=build /usr/app/target/*.jar /app/user-service.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/user-service.jar"]
