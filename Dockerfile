FROM openjdk:11-jdk-slim

COPY target/QrBandExecutableJar-0.0.2-QRTEST.jar QrBandExecutableJar-0.0.2-QRTEST.jar
ENTRYPOINT ["java","-jar","/QrBandExecutableJar-0.0.2-QRTEST.jar"]