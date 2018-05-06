package io.github.alkarn.open.flashcards;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.alkarn.tools.Evaluator;
import io.github.alkarn.tools.EvaluatorImpl;
import io.github.alkarn.tools.Transformer;
import io.github.alkarn.tools.TransformerImpl;

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

}
