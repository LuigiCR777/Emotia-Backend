FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app

# copiar todo el proyecto
COPY . .

# entrar a donde está el pom.xml
WORKDIR /app/java

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre

WORKDIR /app

# copiar el jar generado desde la carpeta correcta
COPY --from=build /app/java/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]