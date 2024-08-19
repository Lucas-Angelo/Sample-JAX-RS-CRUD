FROM maven:3.8.1-openjdk-11 as build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package

FROM tomee:latest
WORKDIR /app
COPY --from=build /app/target/*.war /usr/local/tomee/webapps/
CMD ["catalina.sh", "run"]
EXPOSE 8080