FROM openjdk:12
ADD ./target/config-server.jar config-server.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/config-server.jar"]