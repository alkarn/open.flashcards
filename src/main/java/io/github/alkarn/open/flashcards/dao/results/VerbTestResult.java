package io.github.alkarn.open.flashcards.dao.results;

import java.util.Map;

import io.github.alkarn.open.flashcards.dao.Verb;
import io.github.alkarn.open.flashcards.dao.VerbQuestion;

public class VerbTestResult extends WordTestResult {

    public VerbTestResult(Verb verb, VerbQuestion verbQuestion) {
        super(verb, verbQuestion);
    }

    public boolean isSimplePresentCorrect(String personalPronoun) {
        Map<String, String> simplePresent = ((VerbQuestion) getWordQuestion()).getSimplePresent();
        if (simplePresent == null || simplePresent.get(personalPronoun.toString()) == null || simplePresent.get(personalPronoun.toString()).isEmpty()) {
            return false;
        }
        return (((Verb) getWord()).getSimplePresent().get(personalPronoun).equals(simplePresent.get(personalPronoun.toString())));
    }

    public String getCorrectSimplePresent(String personalPronoun) {
        return ((Verb) getWord()).getSimplePresent().get(personalPronoun.toString());
    }

}
