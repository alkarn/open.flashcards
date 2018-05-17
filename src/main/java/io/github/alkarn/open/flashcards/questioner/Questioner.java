package io.github.alkarn.open.flashcards.questioner;

import java.util.Optional;

import io.github.alkarn.open.flashcards.dao.AdjectiveQuestion;
import io.github.alkarn.open.flashcards.dao.AdverbQuestion;
import io.github.alkarn.open.flashcards.dao.NounQuestion;
import io.github.alkarn.open.flashcards.dao.VerbQuestion;

public interface Questioner {

	public Optional<NounQuestion> generateNounQuestion();

	public Optional<AdverbQuestion> generateAdverbQuestion();

	public Optional<AdjectiveQuestion> generateAdjectiveQuestion();

	public Optional<VerbQuestion> generateVerbQuestion();

}
