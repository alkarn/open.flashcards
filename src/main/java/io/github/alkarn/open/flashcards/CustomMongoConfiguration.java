package io.github.alkarn.open.flashcards;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.MongoClient;

@Configuration
public class CustomMongoConfiguration extends AbstractMongoConfiguration {

    @Value("${mongo.host}")
    private String mongoHost;

    @Value("${mongo.port}")
    private int mongoPort;

    @Value("${mongo.db}")
    private String mongoDB;

    @Override
    public MongoClient mongoClient() {
        return new MongoClient(mongoHost, mongoPort);
    }

    @Override
    protected String getDatabaseName() {
        return mongoDB;
    }

}
