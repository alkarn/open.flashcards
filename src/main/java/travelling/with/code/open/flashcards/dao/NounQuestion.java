package travelling.with.code.open.flashcards.dao;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class NounQuestion {

    private Noun word;

    private String userTranslation;

    private Map<String, String> userAttributes;

    /**
     * If a "simple" constructor does not exist an <init> exception will occur.
     */
    public NounQuestion() {
        super();
    }

    public NounQuestion(Noun word) {
        this.word = word;
        Field[] fields = word.getClass().getDeclaredFields();
        userAttributes = Arrays.asList(fields).stream().collect(Collectors.toMap(Field::getName, field -> ""));
    }

    public Noun getWord() {
        return word;
    }

    public void setWord(Noun word) {
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
