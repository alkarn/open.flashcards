package io.github.alkarn.open.flashcards.dao;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class VerbDto extends WordDto {

    private static ResourceBundle personalPronouns = ResourceBundle.getBundle("personalPronouns");

    private Map<String, String> simplePresent;

    public VerbDto() {
        super();
        simplePresent = new LinkedHashMap<>();
        for (PersonalPronoun pp : PersonalPronoun.values()) {
            simplePresent.put(personalPronouns.getString(pp.toString()), null);
        }
    }

    public Map<String, String> getSimplePresent() {
        return simplePresent;
    }

    public void setSimplePresent(Map<String, String> simplePresent) {
        this.simplePresent = simplePresent;
    }
}
