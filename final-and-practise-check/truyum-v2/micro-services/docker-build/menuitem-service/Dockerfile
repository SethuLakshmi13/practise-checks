FROM openjdk:8-jdk-alpine
COPY target/menuitem-service-0.0.1-SNAPSHOT.jar menu.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom -Djava.net.preferIPv4Stack=true","-jar","/menu.jar"]