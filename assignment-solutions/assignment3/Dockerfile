FROM openjdk:21
ARG JAR_FILE=target/assignment3-0.0.1.jar
COPY ${JAR_FILE} myapp.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/myapp.jar"]