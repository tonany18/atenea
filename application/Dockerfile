FROM openjdk:11-jre-slim
ENV JAVA_APP_JAR demo-0.0.1-SNAPSHOT.jar
WORKDIR /app/
COPY target/$JAVA_APP_JAR .
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar $JAVA_APP_JAR ${0} ${@}"]