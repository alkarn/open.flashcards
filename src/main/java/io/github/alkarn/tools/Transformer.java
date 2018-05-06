package io.github.alkarn.tools;

import io.github.alkarn.open.flashcards.dao.Noun;
import io.github.alkarn.open.flashcards.dao.NounDto;

public interface Transformer {

    public Noun transform(NounDto nounDto);

}
