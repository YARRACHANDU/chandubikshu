FROM maven:3.5.4-openjdk-17 As build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/chandubikshu-0.0.1-SNAPSHOT.jar chandubikshu.jar  
EXPOSE 8080
ENTRYPOINT ["java","-jar","chandubikshu.jar"]