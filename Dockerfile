FROM openjdk:8
MAINTAINER Suchith Kumar suchithkumar.ch@gmail.com
COPY ./target/SciCal-1.0-SNAPSHOT.jar ./
WORKDIR ./
CMD ["java", "-cp", "SciCal-1.0-SNAPSHOT.jar", "SciCal.My_Main"]
