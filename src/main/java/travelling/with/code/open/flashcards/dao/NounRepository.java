package travelling.with.code.open.flashcards.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface NounRepository extends MongoRepository<Noun, String> {

}
