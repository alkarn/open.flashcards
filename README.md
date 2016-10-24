# Open Flashcards
An open source tool to help you learn and revise words, while you are studying a foreign language. It is a desktop application, that makes use of [Spring Boot](http://projects.spring.io/spring-boot/), [Thymeleaf](http://www.thymeleaf.org/) and [MongoDB](https://www.mongodb.org/) to expose a responsive [Bootstrap](http://getbootstrap.com/) browser GUI, that can be used to add new words in the database or test yourself with the ones already registered.

## How to run

### Docker Compose

The easiest way to run the application is using [Docker](https://www.docker.com/) and [Docker Compose](https://www.docker.com/products/docker-compose). Once you have [installed Docker Engine](https://docs.docker.com/engine/installation/) and also [Docker Compose](https://docs.docker.com/compose/install/), get the source code either by [cloning the Github repository](https://help.github.com/articles/cloning-a-repository/) or by [downloading the zip file](https://github.com/atrav/open.flashcards/archive/master.zip). Then, inside the project's directory run:

    docker-compose up -d 
    
that will prepare the containers needed for the application to run. Then you can browse the application at [http://localhost:8090/flashcards](http://localhost:8090/flashcards).

### Docker

Docker Compose makes use of Docker Engine and orchestrates the actions that need to be done to run the application. You can also run the project using plain Docker, as long as you do the same things that Docker Compose is configured to do. Specifically, you will need to create 3 containers:

* a data-only container that will be used as a datastore.
* a database container that will run MongoDB.
* a web application container that will run the actual application.

To create the data-only container:

    docker create -v /data/db --name data_container ubuntu:16.04

To create the database container and run it linked to the data-only container:

    docker build --tag alkarn/mongodb -f Dockerfile_MongoDB .
    docker run -d --volumes-from data_container --name mongodb alkarn/mongodb

To create the application container and run it linked to the database container:

    docker build --tag atrav/flashcards .
    docker run -d -p 8090:8080 --link mongodb:mongodb --name flashcards atrav/flashcards 
    
Then you can browse at [http://localhost:8090/flashcards](http://localhost:8090/flashcards).

### Maven

Of course, you can still build the project using Maven, by typing
 
    mvn install

in the source directory. This will create a `target/open.flashcards-1.0-SNAPSHOT.jar` jar file, that you can then run with:

    java -jar target/open.flashcards-1.0-SNAPSHOT.jar
    
from the source directory. In this case though, you have to also:

* manually [install MongoDB](https://docs.mongodb.org/manual/installation/)
* add a `mongo` alias in your local `/etc/hosts` file corresponding to your localhost

Then you can browse at [http://localhost:8090/flashcards](http://localhost:8090/flashcards).
