package io.github.alkarn.utils;

import io.github.alkarn.open.flashcards.dao.Adverb;
import io.github.alkarn.open.flashcards.dao.AdverbDto;
import io.github.alkarn.open.flashcards.dao.Noun;
import io.github.alkarn.open.flashcards.dao.NounDto;

public interface Transformer {

    public Noun transform(NounDto nounDto);

    public Adverb transform(AdverbDto nounDto);

}
