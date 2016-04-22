FROM  java:8
COPY  target/open.flashcards-1.0-SNAPSHOT.jar /usr
WORKDIR /usr
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "open.flashcards-1.0-SNAPSHOT.jar"]

