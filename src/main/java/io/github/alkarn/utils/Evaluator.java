package io.github.alkarn.utils;

import io.github.alkarn.open.flashcards.dao.NounDto;
import io.github.alkarn.open.flashcards.dao.NounQuestion;
import io.github.alkarn.open.flashcards.dao.results.NounTestResult;

public interface Evaluator {

    public boolean isValid(NounDto nounDto);

    public String getSuccessMessage(NounDto nounDto);

    public String getErrorMessage(NounDto nounDto);

    public NounTestResult evaluateUserAnswer(NounQuestion nounQuestion) throws Exception;

}
