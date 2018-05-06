package io.github.alkarn.open.flashcards.dao;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class SuperQuestion<T extends Word> {

    private final Class<T> partOfSpeech;

    private Map<String, String> wordAttributes;

    private Map<String, String> partOfSpeechAttributes;

    public SuperQuestion(Class<T> partOfSpeech, T word) throws Exception {
        this.partOfSpeech = partOfSpeech;
        Field[] wordFields = Word.class.getDeclaredFields();
        wordAttributes = Arrays.asList(wordFields).stream().collect(Collectors.toMap(Field::getName, field -> getValue(field, word)));
        Field[] partOfSpeechFields = word.getClass().getDeclaredFields();
        partOfSpeechAttributes = Arrays.asList(partOfSpeechFields).stream().collect(Collectors.toMap(Field::getName, field -> getValue(field, word)));
    }

    private String getValue(Field field, Word word) {
        String result = null;
        try {
            result = field.get(word).toString();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean validateAnswer() {


        return false;
    }

    public Map<String, String> getWordAttributes() {
        return wordAttributes;
    }

    public void setWordAttributes(Map<String, String> wordAttributes) {
        this.wordAttributes = wordAttributes;
    }

    public Map<String, String> getPartOfSpeechAttributes() {
        return partOfSpeechAttributes;
    }

    public void setPartOfSpeechAttributes(Map<String, String> partOfSpeechAttributes) {
        this.partOfSpeechAttributes = partOfSpeechAttributes;
    }

    public Class<T> getPartOfSpeech() {
        return partOfSpeech;
    }

}
