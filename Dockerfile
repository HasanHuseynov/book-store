FROM eclipse-temurin:17-jdk-alpine
ADD build/libs/*.jar app.jar
COPY src/main/resources/liquibase/changelog-master.xml /liquibase/changelog/changelog-master.xml
ENTRYPOINT ["java","-jar","app.jar"]
