FROM adoptopenjdk/openjdk13:jre-13.0.2_8-alpine
WORKDIR /workspace/app
COPY interview-1.0.0.jar app.jar
COPY application.properties .
ENV JAVA_OPTS="-Xmx512m"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar app.jar" ]
