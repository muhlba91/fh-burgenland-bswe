FROM openjdk:22-slim

COPY build/libs/bswe.jar /app.jar

EXPOSE 8080/tcp

CMD ["java", "-jar", "/app.jar"]
