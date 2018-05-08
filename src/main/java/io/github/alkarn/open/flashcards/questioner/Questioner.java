package io.github.alkarn.open.flashcards.questioner;

import java.util.Optional;

import io.github.alkarn.open.flashcards.dao.AdjectiveQuestion;
import io.github.alkarn.open.flashcards.dao.AdverbQuestion;
import io.github.alkarn.open.flashcards.dao.NounQuestion;

public interface Questioner {

	public Optional<NounQuestion> generateNounQuestion();

	public Optional<AdverbQuestion> generateAdverbQuestion();

	public Optional<AdjectiveQuestion> generateAdjectiveQuestion();

	/**
	 * Should be called after the user has answered the specific question, to evaluate the question and how
	 * often it should be repeated based on user's answer.
	 *
	 * @param question - the answered question.
	 */
//	public void evaluateQuestion(OldAnsweredQuestion question);


}
