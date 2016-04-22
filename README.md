# open.flashcards
An open source tool to help you learn and revise words while you learn a new language.

## How to run

You can run the project using Docker. Specifically you will need to create 3 containers:

* a data-only container that will be used as a plain datastore.
* a database container that will run MongoDB.
* a web application container that will run the actual application.

To create the data-only container:

docker create -v /data/db --name data_container ubuntu

To create the database container:

docker build --tag atrav/mongo -f Dockerfile_MongoDB .

and then:

docker run -d -p 28017:27017 --volumes-from data_container --name mongo atrav/mongo

Finally, to create the application container:

docker build --tag atrav/flashcards .

and then:

docker run -d -p 8090:8080 --link mongo:mongo --name flashcards atrav/flashcards 