package travelling.with.code.open.flashcards.questioner;

import java.util.Optional;

import travelling.with.code.open.flashcards.dao.Noun;
import travelling.with.code.open.flashcards.dao.OldAnsweredQuestion;
import travelling.with.code.open.flashcards.dao.OldQuestion;

public interface Questioner {

    /**
     * Will use a repository where various questions are available to choose the next one that will be displayed to the user.
     * If the repository is empty it will return null.
     *
     * @return the next question for the user to answer or null if there are no available questions.
     */
	public Optional<OldQuestion> generateQuestion();

	/**
	 * Should be called after the user has answered the specific question, to evaluate the question and how
	 * often it should be repeated based on user's answer.
	 *
	 * @param question - the answered question.
	 */
	public void evaluateQuestion(OldAnsweredQuestion question);

	public Noun generateNoun();

}
