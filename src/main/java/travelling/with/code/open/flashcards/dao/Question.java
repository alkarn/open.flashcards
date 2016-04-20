package travelling.with.code.open.flashcards.dao;

import org.springframework.data.annotation.Id;

public class Question  {

    @Id
	private String word;
	private String article;
	private String userArticle;
	private Boolean isArticleCorrect;
	private String translation;
	private String userTranslation;
	private Boolean isTranslationCorrect;
	private String helpPhrase;
	private String category;

	public Question() {
		super();
	}

	public Question(String word, String translation, String helpPhrase, String article, String category) {
		super();
		this.word = word;
		this.translation = translation;
		this.helpPhrase = helpPhrase;
		this.article = article;
		this.category = category;
	}

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getUserArticle() {
        return userArticle;
    }

    public void setUserArticle(String userArticle) {
        this.userArticle = userArticle;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getUserTranslation() {
        return userTranslation;
    }

    public void setUserTranslation(String userTranslation) {
        this.userTranslation = userTranslation;
    }

    public String getHelpPhrase() {
        return helpPhrase;
    }

    public void setHelpPhrase(String helpPhrase) {
        this.helpPhrase = helpPhrase;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getIsArticleCorrect() {
        return isArticleCorrect;
    }

    public void setIsArticleCorrect(Boolean isArticleCorrect) {
        this.isArticleCorrect = isArticleCorrect;
    }

    public Boolean getIsTranslationCorrect() {
        return isTranslationCorrect;
    }

    public void setIsTranslationCorrect(Boolean isTranslationCorrect) {
        this.isTranslationCorrect = isTranslationCorrect;
    }

}
