package travelling.with.code.open.flashcards.dao;

public class AnsweredQuestion extends Question {

    private String userArticle;
    private Boolean isArticleCorrect;
    private String userTranslation;
    private Boolean isTranslationCorrect;

    public AnsweredQuestion() {
        super();
    }

    public AnsweredQuestion(String word, String translation, String helpPhrase, String article, String category) {
        super(word, translation, helpPhrase, article, category);
    }

    public AnsweredQuestion(Question question) {
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
