FROM gradle:latest AS BUILD
WORKDIR /app
COPY . .
RUN gradle clean
RUN gradle bootJar

FROM amazoncorretto:17.0.9-al2023-headless
EXPOSE 8080
ENV APP_HOME=/app
ENV JAR_NAME=Mosstures.jar
WORKDIR $APP_HOME
COPY ./textures ./textures
COPY --from=BUILD $APP_HOME/build/libs/*.jar $JAR_NAME
ENTRYPOINT exec java -jar $JAR_NAME
