package io.github.alkarn.open.flashcards.dao;

public class WordDto {

    protected String literal;
    protected String translation;
    protected String helpPhrase;

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

}
