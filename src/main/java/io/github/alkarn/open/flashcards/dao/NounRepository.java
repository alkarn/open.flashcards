package io.github.alkarn.open.flashcards.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface NounRepository extends MongoRepository<Noun, String> {

    @Override
    Optional<Noun> findById(@Param("id") String id);

}
