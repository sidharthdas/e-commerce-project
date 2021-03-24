FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/Spring-Docker.jar Spring-Docker.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "Spring-Docker.jar"]