package travelling.with.code.open.flashcards.questioner;

public class Answer {

	private String translation;
	private String article;
	private Boolean isArticleCorrect;
	private Boolean isTranslationCorrect;

	public Answer() {
		super();
	}

	public Answer(String translation, String article) {
		super();
		this.translation = translation;
		this.article = article;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
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
