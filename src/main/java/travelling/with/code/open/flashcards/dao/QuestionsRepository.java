package travelling.with.code.open.flashcards.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionsRepository extends MongoRepository<Question, String> {

}
