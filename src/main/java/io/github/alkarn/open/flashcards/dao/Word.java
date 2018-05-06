package io.github.alkarn.open.flashcards.dao;

import org.springframework.data.annotation.Id;

/**
 * A class that represents a word of the language the user is trying to learn.
 *
 * @author <a href="mailto:alex.a.karnezis@gmail.com">Alex</a>
 */
public class Word {

    /**
     * The maximum value {@link Word#difficulty} field can take. Having a difficulty close to the maximum
     * means that the user is not familiar with this word yet and it will be very probable that it will be prompted
     * to the user.
     */
    public static Integer MAX_DIFFICULTY = 30000;

    /**
     * The minimum value {@link Word#difficulty} field can take. Having a difficulty close to the minimum
     * means that the user is very familiar with this word and it will be improbable that it will be prompted
     * to the user.
     */
    public static Integer MIN_DIFFICULTY = 1;

    /**
     * The actual word. For example it could be {@literal bonjour} for the French salutation phrase.
     * It is also the id of the word record in the persistent layer.
     */
    @Id
    private String literal;

    /**
     * Word's translation in the language that the user is familiar with.
     */
    private String translation;

    /**
     * A phrase in the language the user is trying to learn, that will help him remember this word and
     * probably correspond it with some event or mental picture.
     */
    private String helpPhrase;

    /**
     * An integer that represents how well the user knows this word, based on previous answers he gave, when
     * asked for a translation.
     */
    private Integer difficulty;


    public Word(String literal, String translation, String helpPhrase) {
        this.literal = literal;
        this.translation = translation;
        this.helpPhrase = helpPhrase;
        this.difficulty = MAX_DIFFICULTY;
    }


    public String getLiteral() {
        return literal;
    }

    public void setLiteral(String literal) {
        this.literal = literal;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getHelpPhrase() {
        return helpPhrase;
    }

    public void setHelpPhrase(String helpPhrase) {
        this.helpPhrase = helpPhrase;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

}
