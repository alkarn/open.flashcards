package io.github.alkarn.utils;

import io.github.alkarn.open.flashcards.dao.AdjectiveQuestion;
import io.github.alkarn.open.flashcards.dao.AdverbQuestion;
import io.github.alkarn.open.flashcards.dao.NounQuestion;
import io.github.alkarn.open.flashcards.dao.VerbQuestion;
import io.github.alkarn.open.flashcards.dao.WordDto;
import io.github.alkarn.open.flashcards.dao.results.AdjectiveTestResult;
import io.github.alkarn.open.flashcards.dao.results.AdverbTestResult;
import io.github.alkarn.open.flashcards.dao.results.NounTestResult;
import io.github.alkarn.open.flashcards.dao.results.VerbTestResult;

public interface Evaluator {

    public boolean isValid(WordDto wordDto);

    public String getSuccessMessage(WordDto wordDto);

    public String getErrorMessage(WordDto wordDto);

    public NounTestResult evaluateUserAnswer(NounQuestion nounQuestion) throws Exception;

    public AdverbTestResult evaluateUserAnswer(AdverbQuestion adverbQuestion) throws Exception;

    public AdjectiveTestResult evaluateUserAnswer(AdjectiveQuestion adjectiveQuestion) throws Exception;

    public VerbTestResult evaluateUserAnswer(VerbQuestion verbQuestion) throws Exception;

}
