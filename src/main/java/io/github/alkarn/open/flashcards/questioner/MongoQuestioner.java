package io.github.alkarn.open.flashcards.questioner;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import io.github.alkarn.open.flashcards.dao.Adjective;
import io.github.alkarn.open.flashcards.dao.AdjectiveQuestion;
import io.github.alkarn.open.flashcards.dao.AdjectiveRepository;
import io.github.alkarn.open.flashcards.dao.Adverb;
import io.github.alkarn.open.flashcards.dao.AdverbQuestion;
import io.github.alkarn.open.flashcards.dao.AdverbRepository;
import io.github.alkarn.open.flashcards.dao.Noun;
import io.github.alkarn.open.flashcards.dao.NounQuestion;
import io.github.alkarn.open.flashcards.dao.NounRepository;
import io.github.alkarn.open.flashcards.dao.Verb;
import io.github.alkarn.open.flashcards.dao.VerbQuestion;
import io.github.alkarn.open.flashcards.dao.VerbRepository;

@Component
public class MongoQuestioner implements Questioner {

    private static int GET_PAGE = 0;
    private static int PAGE_SIZE = 10;

    @Autowired
    private NounRepository nounRepository;

    @Autowired
    private AdverbRepository adverbRepository;

    @Autowired
    private AdjectiveRepository adjectiveRepository;

    @Autowired
    private VerbRepository verbRepository;

    private Queue<Noun> nounsToBeAsked = new LinkedList<>();
    private Queue<Adverb> adverbsToBeAsked = new LinkedList<>();
    private Queue<Adjective> adjectivesToBeAsked = new LinkedList<>();
    private Queue<Verb> verbsToBeAsked = new LinkedList<>();

    @Override
    public Optional<NounQuestion> generateNounQuestion() {
        if (nounsToBeAsked.isEmpty()) {
            nounRepository.findAll(PageRequest.of(GET_PAGE, PAGE_SIZE)).stream().forEach(noun -> nounsToBeAsked.add(noun));
        }
        return Optional.ofNullable(new NounQuestion(nounsToBeAsked.poll().getLiteral()));
    }

    @Override
    public Optional<AdverbQuestion> generateAdverbQuestion() {
        if (adverbsToBeAsked.isEmpty()) {
            adverbRepository.findAll(PageRequest.of(GET_PAGE, PAGE_SIZE)).stream().forEach(adverb -> adverbsToBeAsked.add(adverb));
        }
        return Optional.ofNullable(new AdverbQuestion(adverbsToBeAsked.poll().getLiteral()));
    }

    @Override
    public Optional<AdjectiveQuestion> generateAdjectiveQuestion() {
        if (adjectivesToBeAsked.isEmpty()) {
            adjectiveRepository.findAll(PageRequest.of(GET_PAGE, PAGE_SIZE)).stream().forEach(adjective -> adjectivesToBeAsked.add(adjective));
        }
        return Optional.ofNullable(new AdjectiveQuestion(adjectivesToBeAsked.poll().getLiteral()));
    }

    @Override
    public Optional<VerbQuestion> generateVerbQuestion() {
        if (verbsToBeAsked.isEmpty()) {
            verbRepository.findAll(PageRequest.of(GET_PAGE, PAGE_SIZE)).stream().forEach(verb -> verbsToBeAsked.add(verb));
        }
        return Optional.ofNullable(new VerbQuestion(verbsToBeAsked.poll().getLiteral()));
    }

}
