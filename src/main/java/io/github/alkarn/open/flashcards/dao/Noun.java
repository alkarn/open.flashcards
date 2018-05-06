package io.github.alkarn.open.flashcards.dao;

/**
 * A class that represents a noun of the language the user is trying to learn.
 *
 * @author <a href="mailto:travelling.with.code@gmail.com">Alex</a>
 */
public class Noun extends Word {

    /**
     * Unlike English, many languages (the ones I am interested in among them) correspond
     * nouns to specific articles, based on their gender.
     */
    private String article;

    public Noun(String literal, String translation, String helpPhrase, String article) {
        super(literal, translation, helpPhrase);
        this.article = article;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

}
