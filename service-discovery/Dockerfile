FROM eclipse-temurin:21-alpine

VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/service-discovery-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
CMD ["java", "-jar", "app.jar"]