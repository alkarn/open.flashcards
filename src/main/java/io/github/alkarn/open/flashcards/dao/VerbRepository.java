package io.github.alkarn.open.flashcards.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface VerbRepository extends MongoRepository<Verb, String> {

}
