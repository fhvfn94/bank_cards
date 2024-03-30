FROM openjdk:17 AS builder
RUN apt-get update && apt-get install -y maven
WORKDIR /card
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN mvn package -DskipTests

FROM openjdk:17-jre-slim
WORKDIR /card
COPY --from=builder /card/target/*.jar card.jar
CMD ["java", "-jar", "card.jar"]
