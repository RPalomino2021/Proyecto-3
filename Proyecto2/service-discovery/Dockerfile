FROM openjdk:12
ADD ./target/service-discovery.jar service-discovery.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "/service-discovery.jar"]