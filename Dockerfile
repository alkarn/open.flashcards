FROM  maven:3.3.3-jdk-8
RUN mkdir /home/open.flashcards
WORKDIR /home/open.flashcards
COPY  pom.xml /home/open.flashcards/pom.xml
COPY src /home/open.flashcards/src
RUN mvn package -Dmaven.test.skip=true
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/home/open.flashcards/target/open.flashcards-0.0.1-SNAPSHOT.jar"]
