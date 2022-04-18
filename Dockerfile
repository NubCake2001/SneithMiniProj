FROM openjdk:8
MAINTAINER nubcake2001@gmail.com
COPY ./target/SciCal-1.0-SNAPSHOT-jar-with-dependencies.jar ./
WORKDIR ./
CMD ["java", "-jar", "SciCal-1.0-SNAPSHOT-jar-with-dependencies.jar"]
