package io.github.alkarn.open.flashcards;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.alkarn.open.flashcards.questioner.MongoQuestioner;
import io.github.alkarn.open.flashcards.questioner.Questioner;
import io.github.alkarn.utils.Evaluator;
import io.github.alkarn.utils.EvaluatorImpl;
import io.github.alkarn.utils.Transformer;
import io.github.alkarn.utils.TransformerImpl;

@Configuration
public class FlashcardConfiguration {

    @Bean
    public Evaluator evaluator() {
        return new EvaluatorImpl();
    }

    @Bean
    public Transformer transformer() {
        return new TransformerImpl();
    }

    @Bean
    public Questioner questioner() {
        return new MongoQuestioner();
    }
}
