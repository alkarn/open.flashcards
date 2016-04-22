package travelling.with.code.open.flashcards;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
public class MongoConfiguration extends AbstractMongoConfiguration {

    private static final String MONGO_ADDR = "MONGO_PORT_27017_TCP_ADDR";
    private static final String DB_NAME = "flashcards";

    @Override
    public String getDatabaseName() {
        return DB_NAME;
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        Map<String, String> enviromentalVariables = System.getenv();
        String mongoIp = enviromentalVariables.get(MONGO_ADDR);
        return new MongoClient(mongoIp != null ? mongoIp : "localhost", 27017);
    }
}
