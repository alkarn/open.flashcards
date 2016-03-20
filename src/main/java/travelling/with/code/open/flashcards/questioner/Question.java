package travelling.with.code.open.flashcards.questioner;

import java.util.Optional;

public interface Question {

	public String getForeignWord();

	public String getTranslation();

	public String getHelpPhrase();

	public Optional<String> getArticle();

	public Optional<String> getCategory();

}
