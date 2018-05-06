package io.github.alkarn.open.flashcards.questioner;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.alkarn.open.flashcards.dao.NounQuestion;
import io.github.alkarn.open.flashcards.dao.NounRepository;

@Component
public class MongoQuestioner implements Questioner {

    @Autowired
    private NounRepository nounRepository;

    @Override
    public Optional<NounQuestion> generateNounQuestion() {
        return Optional.ofNullable(new NounQuestion(nounRepository.findAll().get(0).getLiteral()));
    }

//    @Override
//    public void evaluateQuestion(OldAnsweredQuestion answeredQuestion) {
//        if (answeredQuestion.getDifficulty() < (OldQuestion.MAX_DIFFICULTY - OldQuestion.MIN_DIFFICULTY) * 1 / 10) {
//            answeredQuestion.setDifficulty((OldQuestion.MAX_DIFFICULTY - OldQuestion.MIN_DIFFICULTY) / 2);
//        }
//        if (answeredQuestion.getIsArticleCorrect()) {
//            answeredQuestion.setDifficulty(answeredQuestion.getDifficulty() * 4 / 5);
//        }
//        if (answeredQuestion.getIsTranslationCorrect()) {
//            answeredQuestion.setDifficulty(answeredQuestion.getDifficulty() / 2);
//        }
//        OldQuestion question = new  OldQuestion(answeredQuestion);
//        questionRepository.save(question);
//    }


}
