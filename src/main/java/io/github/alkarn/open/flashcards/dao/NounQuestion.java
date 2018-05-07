package io.github.alkarn.open.flashcards.dao;

public class NounQuestion extends WordQuestion {

    public NounQuestion(String literal) {
        super(literal);
    }
    private String userArticle;

    public String getUserArticle() {
        return userArticle;
    }
    public void setUserArticle(String userArticle) {
        this.userArticle = userArticle;
    }

}
