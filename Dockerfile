FROM openjdk:latest

WORKDIR /app

COPY target/desafiopicpay-0.0.1-SNAPSHOT.war /app/desafiopicpay.war

ENTRYPOINT ["java", "-jar", "desafiopicpay.war"]
