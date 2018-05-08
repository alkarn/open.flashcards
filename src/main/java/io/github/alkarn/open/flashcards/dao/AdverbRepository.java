package io.github.alkarn.open.flashcards.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface AdverbRepository extends MongoRepository<Adverb, String> {

    @Override
    Optional<Adverb> findById(@Param("id") String id);

}
