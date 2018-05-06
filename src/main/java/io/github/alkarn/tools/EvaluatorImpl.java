package io.github.alkarn.tools;

import io.github.alkarn.open.flashcards.dao.NounDto;

public class EvaluatorImpl implements Evaluator {

    @Override
    public boolean isValid(NounDto nounDto) {
        if (nounDto == null || nounDto.getLiteral() == null || nounDto.getLiteral().isEmpty() ||
            nounDto.getArticle() == null || nounDto.getArticle().isEmpty() ||
            nounDto.getTranslation() == null || nounDto.getTranslation().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String getSuccessMessage(NounDto nounDto) {
        return nounDto.getArticle() + " " + nounDto.getLiteral() + " successfully added";
    }

    @Override
    public String getErrorMessage(NounDto nounDto) {
        if (nounDto == null) {
            return "Please insert a new noun";
        } else if (nounDto.getLiteral() == null || nounDto.getLiteral().isEmpty()) {
            return "Please fill noun";
        } else if (nounDto.getArticle() == null || nounDto.getArticle().isEmpty()) {
            return "Please fill article";
        } else if (nounDto.getTranslation() == null || nounDto.getTranslation().isEmpty()) {
            return "Plese fill translation";
        } else {
            return "An unexpected error occured. If you continue having problems, please contact administrator at " + Administration.ADMIN_EMAIL;
        }
    }

}
