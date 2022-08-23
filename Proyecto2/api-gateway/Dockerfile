FROM openjdk:12
ADD ./target/api-gateway.jar api-gateway.jar
EXPOSE 8088
ENTRYPOINT ["java", "-jar", "/api-gateway.jar"]