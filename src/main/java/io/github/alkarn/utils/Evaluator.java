package io.github.alkarn.utils;

import io.github.alkarn.open.flashcards.dao.NounQuestion;
import io.github.alkarn.open.flashcards.dao.WordDto;
import io.github.alkarn.open.flashcards.dao.results.NounTestResult;

public interface Evaluator {

    public boolean isValid(WordDto wordDto);

    public String getSuccessMessage(WordDto wordDto);

    public String getErrorMessage(WordDto wordDto);

    public NounTestResult evaluateUserAnswer(NounQuestion nounQuestion) throws Exception;

}
