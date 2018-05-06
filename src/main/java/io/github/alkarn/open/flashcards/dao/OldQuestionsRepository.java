package io.github.alkarn.open.flashcards.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OldQuestionsRepository extends MongoRepository<OldQuestion, String> {

}
