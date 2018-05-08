package io.github.alkarn.open.flashcards.dao.results;

import io.github.alkarn.open.flashcards.dao.Noun;
import io.github.alkarn.open.flashcards.dao.NounQuestion;

public class NounTestResult extends WordTestResult {

    public NounTestResult(Noun noun, NounQuestion nounQuestion) {
        super(noun, nounQuestion);
    }

    public boolean isArticleCorrect() {
        if (((NounQuestion) getWordQuestion()).getUserArticle() == null || ((NounQuestion) getWordQuestion()).getUserArticle().isEmpty()) {
            return false;
        }
        if (((Noun) getWord()).getArticle().equals(((NounQuestion) getWordQuestion()).getUserArticle())) {
            return true;
        } else {
            return false;
        }
    }

    public String getCorrectArticle() {
        return ((Noun) getWord()).getArticle();
    }
}
