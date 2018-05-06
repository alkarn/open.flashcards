package io.github.alkarn.open.flashcards.dao;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * A class that corresponds to  a question that will be asked to a user.
 *
 * @author <a href="mailto:travelling.with.code@gmail.com">Alex</a>
 */
public class Question<T extends Word> {

    /**
     * The word that will be asked to the user to translate.
     */
    private T word;

    /**
     * The translation that will be provided by the user and will be checked against
     * word's actual translation.
     */
    private String userTranslation;

    /**
     * User's answer to the case specific word attributes, based on the exact type of the word.
     */
    private Map<String, String> userAttributes;


    public Question() {
        super();
    }


    public Question(T word) {
        this.word = word;
        Field[] fields = word.getClass().getDeclaredFields();
        userAttributes = Arrays.asList(fields).stream().collect(Collectors.toMap(Field::getName, Field::getName));
    }


    public T getWord() {
        return word;
    }

    public void setWord(T word) {
        this.word = word;
    }

    public String getUserTranslation() {
        return userTranslation;
    }

    public void setUserTranslation(String userTranslation) {
        this.userTranslation = userTranslation;
    }

    public Map<String, String> getUserAttributes() {
        return userAttributes;
    }

    public void setUserAttributes(Map<String, String> userAttributes) {
        this.userAttributes = userAttributes;
    }

}
