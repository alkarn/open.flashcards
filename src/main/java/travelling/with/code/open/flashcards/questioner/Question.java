package travelling.with.code.open.flashcards.questioner;

import java.util.Optional;

public interface Question {

	public String getForeignWord();

	public String getTranslation();

	public String getHelpPhrase();

	// TODO Aticle should be optional, since English for example does not have distinct articles for nouns.
	public String getArticle();

	public Optional<String> getCategory();

}
