package io.github.alkarn.open.flashcards.dao.results;

import io.github.alkarn.open.flashcards.dao.Noun;
import io.github.alkarn.open.flashcards.dao.NounQuestion;

public class NounTestResult {

    private Noun noun;
    private NounQuestion nounQuestion;

    public NounTestResult(Noun noun, NounQuestion nounQuestion) {
        this.noun = noun;
        this.nounQuestion = nounQuestion;
    }

    public boolean isTranslationCorrect() {
        if (nounQuestion.getUserTranslation() == null || nounQuestion.getUserTranslation().isEmpty()) {
            return false;
        }
        if (noun.getTranslation().equals(nounQuestion.getUserTranslation())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isArticleCorrect() {
        if (nounQuestion.getUserArticle() == null || nounQuestion.getUserArticle().isEmpty()) {
            return false;
        }
        if (noun.getArticle().equals(nounQuestion.getUserArticle())) {
            return true;
        } else {
            return false;
        }
    }

    public String getCorrectArticle() {
        return noun.getArticle();
    }

    public String getCorrectTranslation() {
        return noun.getTranslation();
    }
}
