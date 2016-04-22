# open.flashcards
An open source tool to help you learn and revise words while you learn a new language.

## How to run

You can run the project using Docker. Specifically you will need to create 3 containers:

* a data-only container that will be used as a datastore.
* a database container that will run MongoDB.
* a web application container that will run the actual application.

To create the data-only container:

    docker create -v /data/db --name data_container ubuntu

To create the database container and run it linked to the data-only container:

    docker build --tag atrav/mongo -f Dockerfile_MongoDB .
    docker run -d --volumes-from data_container --name mongo atrav/mongo

To create the application container and run it linked to the database container:

    docker build --tag atrav/flashcards .
    docker run -d -p 8090:8080 --link mongo:mongo --name flashcards atrav/flashcards 
    
Then you can browse at [http://localhost:8090/flashcards-test](http://localhost:8090/flashcards-test)!