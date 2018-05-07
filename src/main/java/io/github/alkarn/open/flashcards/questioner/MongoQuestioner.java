package io.github.alkarn.open.flashcards.questioner;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.alkarn.open.flashcards.dao.Noun;
import io.github.alkarn.open.flashcards.dao.NounQuestion;
import io.github.alkarn.open.flashcards.dao.NounRepository;

@Component
public class MongoQuestioner implements Questioner {

    @Autowired
    private NounRepository nounRepository;

    private Queue<Noun> nounsToBeAsked = new LinkedList<>();

    @Override
    public Optional<NounQuestion> generateNounQuestion() {
        if (nounsToBeAsked.isEmpty()) {
            nounRepository.findAll().stream().forEach(noun -> nounsToBeAsked.add(noun));
        }
        return Optional.ofNullable(new NounQuestion(nounsToBeAsked.poll().getLiteral()));
    }

}
