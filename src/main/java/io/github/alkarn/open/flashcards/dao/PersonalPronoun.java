package io.github.alkarn.open.flashcards.dao;

public enum PersonalPronoun {

    FIRST_SINGULAR("pronoun.singular.first"),
    SECOND_SINGULAR("pronoun.singular.second"),
    THIRD_SINGULAR("pronoun.singular.third"),
    FIRST_PLURAL("pronoun.plural.first"),
    SECOND_PLURAL("pronoun.plural.second"),
    THIRD_PLURAL("pronoun.plural.third");

    private final String name;

    private PersonalPronoun(String s) {
        name = s;
    }

    @Override
    public String toString() {
       return this.name;
    }

}
