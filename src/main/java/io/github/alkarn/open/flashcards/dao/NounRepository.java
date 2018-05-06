package io.github.alkarn.open.flashcards.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface NounRepository extends MongoRepository<Noun, String> {

}
