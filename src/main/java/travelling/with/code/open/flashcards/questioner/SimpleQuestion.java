package travelling.with.code.open.flashcards.questioner;

import java.util.Optional;

public class SimpleQuestion implements Question {

	private String foreignWord;
	private String translation;
	private String helpPhrase;
	private String article;
	private String category;

	public SimpleQuestion(String foreignWord, String translation, String helpPhrase, String article, String category) {
		super();
		this.foreignWord = foreignWord;
		this.translation = translation;
		this.helpPhrase = helpPhrase;
		this.article = article;
		this.category = category;
	}

	@Override
	public String getForeignWord() {
		return foreignWord;
	}

	@Override
	public String getTranslation() {
		return translation;
	}

	@Override
	public String getHelpPhrase() {
		return helpPhrase;
	}

	@Override
	public Optional<String> getArticle() {
		return Optional.of(article);
	}

	@Override
	public Optional<String> getCategory() {
		return Optional.of(category);
	}

}
