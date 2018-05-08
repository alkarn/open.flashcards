package io.github.alkarn.open.flashcards.dao.results;

import io.github.alkarn.open.flashcards.dao.Word;
import io.github.alkarn.open.flashcards.dao.WordQuestion;

public class WordTestResult {

    private Word word;
    private WordQuestion wordQuestion;

    public WordTestResult(Word word, WordQuestion wordQuestion) {
        this.word = word;
        this.wordQuestion = wordQuestion;
    }

    public boolean isTranslationCorrect() {
        if (wordQuestion.getUserTranslation() == null || wordQuestion.getUserTranslation().isEmpty()) {
            return false;
        }
        if (word.getTranslation().equals(wordQuestion.getUserTranslation())) {
            return true;
        } else {
            return false;
        }
    }

    public String getCorrectTranslation() {
        return word.getTranslation();
    }

    public Word getWord() {
        return word;
    }

    public WordQuestion getWordQuestion() {
        return wordQuestion;
    }

}
