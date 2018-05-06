package io.github.alkarn.open.flashcards.dao;

public class OldAnsweredQuestion extends OldQuestion {

    private String userArticle;
    private Boolean isArticleCorrect;
    private String userTranslation;
    private Boolean isTranslationCorrect;

    public OldAnsweredQuestion() {
        super();
    }

    public OldAnsweredQuestion(String word, String translation, String helpPhrase, String article, String category) {
        super(word, translation, helpPhrase, article, category);
    }

    public OldAnsweredQuestion(OldQuestion question) {
        setWord(question.getWord());
        setTranslation(question.getTranslation());
        setArticle(question.getArticle());
        setHelpPhrase(question.getHelpPhrase());
        setCategory(question.getCategory());
        setDifficulty(question.getDifficulty());
    }

    public String getUserArticle() {
        return userArticle;
    }

    public void setUserArticle(String userArticle) {
        this.userArticle = userArticle;
    }

    public Boolean getIsArticleCorrect() {
        return isArticleCorrect;
    }

    public void setIsArticleCorrect(Boolean isArticleCorrect) {
        this.isArticleCorrect = isArticleCorrect;
    }

    public String getUserTranslation() {
        return userTranslation;
    }

    public void setUserTranslation(String userTranslation) {
        this.userTranslation = userTranslation;
    }

    public Boolean getIsTranslationCorrect() {
        return isTranslationCorrect;
    }

    public void setIsTranslationCorrect(Boolean isTranslationCorrect) {
        this.isTranslationCorrect = isTranslationCorrect;
    }


}
