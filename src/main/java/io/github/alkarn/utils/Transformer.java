package io.github.alkarn.utils;

import io.github.alkarn.open.flashcards.dao.Adjective;
import io.github.alkarn.open.flashcards.dao.AdjectiveDto;
import io.github.alkarn.open.flashcards.dao.Adverb;
import io.github.alkarn.open.flashcards.dao.AdverbDto;
import io.github.alkarn.open.flashcards.dao.Noun;
import io.github.alkarn.open.flashcards.dao.NounDto;
import io.github.alkarn.open.flashcards.dao.Verb;
import io.github.alkarn.open.flashcards.dao.VerbDto;

public interface Transformer {

    public Noun transform(NounDto nounDto);

    public Adverb transform(AdverbDto nounDto);

    public Adjective transform(AdjectiveDto adjectiveDto);

    public Verb transform(VerbDto verbDto);

}
