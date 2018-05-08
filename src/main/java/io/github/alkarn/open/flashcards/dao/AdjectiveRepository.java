package io.github.alkarn.open.flashcards.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface AdjectiveRepository extends MongoRepository<Adjective, String> {

    @Override
    Optional<Adjective> findById(@Param("id") String id);

}
