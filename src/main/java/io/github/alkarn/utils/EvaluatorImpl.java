package io.github.alkarn.utils;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import io.github.alkarn.open.flashcards.dao.Noun;
import io.github.alkarn.open.flashcards.dao.NounDto;
import io.github.alkarn.open.flashcards.dao.NounQuestion;
import io.github.alkarn.open.flashcards.dao.NounRepository;
import io.github.alkarn.open.flashcards.dao.WordDto;
import io.github.alkarn.open.flashcards.dao.results.NounTestResult;

public class EvaluatorImpl implements Evaluator {

    @Autowired
    private NounRepository nounRepository;


    @Override
    public boolean isValid(WordDto wordDto) {
        if (wordDto == null || wordDto.getLiteral() == null || wordDto.getLiteral().isEmpty()
                || wordDto.getTranslation() == null || wordDto.getTranslation().isEmpty()) {
            return false;
        }
        if (wordDto instanceof NounDto) {
            return (((NounDto) wordDto).getArticle() == null || ((NounDto) wordDto).getArticle().isEmpty()) ? false : true;
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

}
