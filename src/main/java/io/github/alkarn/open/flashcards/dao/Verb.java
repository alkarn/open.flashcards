package io.github.alkarn.open.flashcards.dao;

import java.util.Map;

/**
 * A class that corresponds to a verb of the language the user is trying to learn.
 *
 * @author <a href="mailto:alex.a.karnezis@gmail.com">Alex</a>
 */
public class Verb extends Word {

    private Map<String, String> simplePresent;

    public Verb(String literal, String translation, String helpPhrase, Map<String, String> simplePresent) {
        super(literal, translation, helpPhrase);
        this.simplePresent = simplePresent;
    }

    public Map<String, String> getSimplePresent() {
        return simplePresent;
    }

    public void setSimplePresent(Map<String, String> simplePresent) {
        this.simplePresent = simplePresent;
    }

}
