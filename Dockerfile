FROM maven:3.8-jdk-11-slim as maven
COPY pom.xml .
RUN mvn -B dependency:go-offline dependency:resolve
COPY src/ src/
RUN mvn -B -o package -DskipTests

FROM openjdk:11-jre-slim
COPY --from=maven target/*.jar app.jar
CMD ["java", "-jar", "app.jar"]