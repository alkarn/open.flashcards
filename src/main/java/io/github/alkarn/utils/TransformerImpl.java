package io.github.alkarn.utils;

import io.github.alkarn.open.flashcards.dao.Adjective;
import io.github.alkarn.open.flashcards.dao.AdjectiveDto;
import io.github.alkarn.open.flashcards.dao.Adverb;
import io.github.alkarn.open.flashcards.dao.AdverbDto;
import io.github.alkarn.open.flashcards.dao.Noun;
import io.github.alkarn.open.flashcards.dao.NounDto;
import io.github.alkarn.open.flashcards.dao.Verb;
import io.github.alkarn.open.flashcards.dao.VerbDto;

public class TransformerImpl implements Transformer {

    @Override
    public Noun transform(NounDto nounDto) {
        return new Noun(nounDto.getLiteral(), nounDto.getTranslation(), nounDto.getHelpPhrase(), nounDto.getArticle());
    }

    @Override
    public Adverb transform(AdverbDto adverbDto) {
        return new Adverb(adverbDto.getLiteral(), adverbDto.getTranslation(), adverbDto.getHelpPhrase());
    }

    @Override
    public Adjective transform(AdjectiveDto adjectiveDto) {
        return new Adjective(adjectiveDto.getLiteral(), adjectiveDto.getTranslation(), adjectiveDto.getHelpPhrase());
    }

    @Override
    public Verb transform(VerbDto verbDto) {
        return new Verb(verbDto.getLiteral(), verbDto.getTranslation(), verbDto.getHelpPhrase(), verbDto.getSimplePresent());
    }

}
