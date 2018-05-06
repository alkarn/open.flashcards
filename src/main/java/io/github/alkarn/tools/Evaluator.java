package io.github.alkarn.tools;

import io.github.alkarn.open.flashcards.dao.NounDto;
import io.github.alkarn.open.flashcards.dao.NounQuestion;

public interface Evaluator {

    public boolean isValid(NounDto nounDto);

    public String getSuccessMessage(NounDto nounDto);

    public String getErrorMessage(NounDto nounDto);

    public boolean evaluateUserAnswer(NounQuestion nounQuestion) throws Exception;

}
