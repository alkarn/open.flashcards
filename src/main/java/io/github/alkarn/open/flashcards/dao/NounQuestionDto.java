package io.github.alkarn.open.flashcards.dao;

public class NounQuestionDto {

    private String literal;
    private String helpPhrase;
    private String userTranslation;
    private String userArticle;

    public String getLiteral() {
        return literal;
    }
    public void setLiteral(String literal) {
        this.literal = literal;
    }
    public String getHelpPhrase() {
        return helpPhrase;
    }
    public void setHelpPhrase(String helpPhrase) {
        this.helpPhrase = helpPhrase;
    }
    public String getUserTranslation() {
        return userTranslation;
    }
    public void setUserTranslation(String userTranslation) {
        this.userTranslation = userTranslation;
    }
    public String getUserArticle() {
        return userArticle;
    }
    public void setUserArticle(String userArticle) {
        this.userArticle = userArticle;
    }

}
