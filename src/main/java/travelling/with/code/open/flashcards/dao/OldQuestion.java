package travelling.with.code.open.flashcards.dao;

import org.springframework.data.annotation.Id;

public class OldQuestion  {

    public static int MAX_DIFFICULTY = 10000;
    public static int MIN_DIFFICULTY = 0;

    @Id
	private String word;
	private String article;
	private String translation;
	private String helpPhrase;
	private String category;
	private Integer difficulty = MAX_DIFFICULTY;

	public OldQuestion() {
	    super();
	}

	public OldQuestion(String word, String translation, String helpPhrase, String article, String category) {
		this.word = word;
		this.translation = translation;
		this.helpPhrase = helpPhrase;
		this.article = article;
		this.category = category;
	}

	public OldQuestion(OldAnsweredQuestion answeredQuestion) {
	    this.word = answeredQuestion.getWord();
        this.translation = answeredQuestion.getTranslation();
        this.helpPhrase = answeredQuestion.getHelpPhrase();
        this.article = answeredQuestion.getArticle();
        this.category = answeredQuestion.getCategory();
        this.difficulty = answeredQuestion.getDifficulty();
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

}
