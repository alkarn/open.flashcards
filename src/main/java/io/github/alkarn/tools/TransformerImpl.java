package io.github.alkarn.tools;

import io.github.alkarn.open.flashcards.dao.Noun;
import io.github.alkarn.open.flashcards.dao.NounDto;

public class TransformerImpl implements Transformer {

    @Override
    public Noun transform(NounDto nounDto) {
        return new Noun(nounDto.getLiteral(), nounDto.getTranslation(), nounDto.getHelpPhrase(), nounDto.getArticle());
    }

}
