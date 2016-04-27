FROM  maven:3.3.3-jdk-8
RUN mkdir /home/open.flashcards
WORKDIR /home/open.flashcards
COPY  pom.xml /home/open.flashcards/pom.xml
COPY src /home/open.flashcards/src
RUN mvn package -Dmaven.test.skip=true
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "target/open.flashcards-1.0-SNAPSHOT.jar"]