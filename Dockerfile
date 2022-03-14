FROM adoptopenjdk/openjdk8:alpine-slim
ADD target/reports-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8087
EXPOSE 27017
ENTRYPOINT ["java", "-jar","/app.jar"]