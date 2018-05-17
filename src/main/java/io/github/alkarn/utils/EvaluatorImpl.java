package io.github.alkarn.utils;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import io.github.alkarn.open.flashcards.dao.Adjective;
import io.github.alkarn.open.flashcards.dao.AdjectiveQuestion;
import io.github.alkarn.open.flashcards.dao.AdjectiveRepository;
import io.github.alkarn.open.flashcards.dao.Adverb;
import io.github.alkarn.open.flashcards.dao.AdverbQuestion;
import io.github.alkarn.open.flashcards.dao.AdverbRepository;
import io.github.alkarn.open.flashcards.dao.Noun;
import io.github.alkarn.open.flashcards.dao.NounDto;
import io.github.alkarn.open.flashcards.dao.NounQuestion;
import io.github.alkarn.open.flashcards.dao.NounRepository;
import io.github.alkarn.open.flashcards.dao.Verb;
import io.github.alkarn.open.flashcards.dao.VerbDto;
import io.github.alkarn.open.flashcards.dao.VerbQuestion;
import io.github.alkarn.open.flashcards.dao.VerbRepository;
import io.github.alkarn.open.flashcards.dao.WordDto;
import io.github.alkarn.open.flashcards.dao.results.AdjectiveTestResult;
import io.github.alkarn.open.flashcards.dao.results.AdverbTestResult;
import io.github.alkarn.open.flashcards.dao.results.NounTestResult;
import io.github.alkarn.open.flashcards.dao.results.VerbTestResult;

public class EvaluatorImpl implements Evaluator {

    @Autowired
    private NounRepository nounRepository;

    @Autowired
    private AdverbRepository adverbRepository;

    @Autowired
    private AdjectiveRepository adjectiveRepository;

    @Autowired
    private VerbRepository verbRepository;


    @Override
    public boolean isValid(WordDto wordDto) {
        if (wordDto == null || wordDto.getLiteral() == null || wordDto.getLiteral().isEmpty()
                || wordDto.getTranslation() == null || wordDto.getTranslation().isEmpty()) {
            return false;
        }
        if (wordDto instanceof NounDto) {
            return (((NounDto) wordDto).getArticle() == null || ((NounDto) wordDto).getArticle().isEmpty()) ? false : true;
        } else if (wordDto instanceof VerbDto) {
            Map<String, String> simplePresent = ((VerbDto) wordDto).getSimplePresent();
            if (simplePresent == null) {
                return false;
            }
            for (String value : simplePresent.values()) {
                if (value == null || value.isEmpty()) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }

    @Override
    public String getSuccessMessage(WordDto wordDto) {
        if (wordDto instanceof NounDto) {
            return ((NounDto) wordDto).getArticle() + " " + wordDto.getLiteral() + " successfully added";
        } else {
            return wordDto.getLiteral() + " successfully added";
        }
    }

    @Override
    public String getErrorMessage(WordDto wordDto) {
        if (wordDto == null) {
            return "Please insert a new word";
        } else if (wordDto.getLiteral() == null || wordDto.getLiteral().isEmpty()) {
            return "Please insert a new word";
        } else if (wordDto.getTranslation() == null || wordDto.getTranslation().isEmpty()) {
            return "Plese fill translation";
        }
        if (wordDto instanceof NounDto) {
            if (((NounDto) wordDto).getArticle() == null || ((NounDto) wordDto).getArticle().isEmpty()) {
                return "Please fill article";
            }
        } else if (wordDto instanceof VerbDto) {
            Map<String, String> simplePresent = ((VerbDto) wordDto).getSimplePresent();
            if (simplePresent == null) {
                return "Please fill simple present";
            }
            for (String personalPronoun : simplePresent.keySet()) {
                if (simplePresent.get(personalPronoun) == null || simplePresent.get(personalPronoun).isEmpty()) {
                    return "Plese fill simple present for " + personalPronoun;
                }
            }
        }
        return null;
    }

    @Override
    public NounTestResult evaluateUserAnswer(NounQuestion nounQuestion) throws Exception {
        Optional<Noun> noun = nounRepository.findById(nounQuestion.getLiteral());
        if (noun.isPresent()) {
            return new NounTestResult(noun.get(), nounQuestion);
        } else {
            // TODO This is an extreme case. How do we handle?
            throw new Exception();
        }

    }

    @Override
    public AdverbTestResult evaluateUserAnswer(AdverbQuestion adverbQuestion) throws Exception {
        Optional<Adverb> adverb = adverbRepository.findById(adverbQuestion.getLiteral());
        if (adverb.isPresent()) {
            return new AdverbTestResult(adverb.get(), adverbQuestion);
        } else {
            // TODO This is an extreme case. How do we handle?
            throw new Exception();
        }
    }

    @Override
    public AdjectiveTestResult evaluateUserAnswer(AdjectiveQuestion adjectiveQuestion) throws Exception {
        Optional<Adjective> adjective = adjectiveRepository.findById(adjectiveQuestion.getLiteral());
        if (adjective.isPresent()) {
            return new AdjectiveTestResult(adjective.get(), adjectiveQuestion);
        } else {
            // TODO This is an extreme case. How do we handle?
            throw new Exception();
        }
    }

    @Override
    public VerbTestResult evaluateUserAnswer(VerbQuestion verbQuestion) throws Exception {
        Optional<Verb> verb = verbRepository.findById(verbQuestion.getLiteral());
        if (verb.isPresent()) {
            return new VerbTestResult(verb.get(), verbQuestion);
        } else {
            // TODO This is an extreme case. How do we handle?
            throw new Exception();
        }
    }

}
