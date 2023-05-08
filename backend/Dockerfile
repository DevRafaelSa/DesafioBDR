FROM openjdk:11-jdk-slim
WORKDIR /backend
COPY . .
RUN ./mvnw package -DskipTests
CMD ["java", "-jar", "target/backend-0.0.1-SNAPSHOT.jar"]

RUN apt-get update && apt-get install -y maven
RUN apt-get install -y openjdk-11-jdk

