FROM gradle:8.2.1-jdk17 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM openjdk:17-jdk-slim
MAINTAINER github/mmarcosab
COPY --from=build /home/gradle/src/build/libs/ /app/
WORKDIR /app
ENTRYPOINT ["java", "-jar", "kotlin-studies-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080