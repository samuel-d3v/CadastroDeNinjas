# ==== STAGE 1: BUILD ====
FROM maven:3.9.12 AS build
WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# ==== STAGE 2: RUN ====
FROM eclipse-temurin:17.0.17_10-jdk
WORKDIR /app

COPY --from=build /app/target/CadastroDeNinjas-0.0.1-SNAPSHOT.jar cadastro-app.jar

EXPOSE 8080
LABEL maintainer="contato@contato.com"

ENTRYPOINT ["java", "-jar", "cadastro-app.jar"]