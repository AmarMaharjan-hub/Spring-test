FROM openjdk:11
COPY src/test/java/com/springtest/springtest /app
WORKDIR /app
RUN javac SpringtestApplication.java
CMD ["java", "SpringtestApplication"]