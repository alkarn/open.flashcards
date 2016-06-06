package travelling.with.code.open.flashcards.questioner;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import travelling.with.code.open.flashcards.dao.Noun;
import travelling.with.code.open.flashcards.dao.OldAnsweredQuestion;
import travelling.with.code.open.flashcards.dao.OldQuestion;
import travelling.with.code.open.flashcards.dao.OldQuestionsRepository;

@Component
public class MongoQuestioner implements Questioner {

    @Autowired
    private OldQuestionsRepository questionRepository;

    private Set<OldQuestion> bufferedQuestions = new HashSet<>();
    private Iterator<OldQuestion> questionIterator = bufferedQuestions.iterator();

	@Override
	public Optional<OldQuestion> generateQuestion() {
	    if (!questionIterator.hasNext()) {
	        bufferQuestions();
	    }
	    if (questionIterator.hasNext()) {
	        return Optional.of(questionIterator.next());
	    } else {
	        return Optional.of(null);
	    }
	}

	private void bufferQuestions() {
        bufferedQuestions.clear();
	    bufferedQuestions.addAll(questionRepository.findAll());
	    questionIterator = bufferedQuestions.iterator();
	}

    @Override
    public void evaluateQuestion(OldAnsweredQuestion answeredQuestion) {
        if (answeredQuestion.getDifficulty() < (OldQuestion.MAX_DIFFICULTY - OldQuestion.MIN_DIFFICULTY) * 1 / 10) {
            answeredQuestion.setDifficulty((OldQuestion.MAX_DIFFICULTY - OldQuestion.MIN_DIFFICULTY) / 2);
        }
        if (answeredQuestion.getIsArticleCorrect()) {
            answeredQuestion.setDifficulty(answeredQuestion.getDifficulty() * 4 / 5);
        }
        if (answeredQuestion.getIsTranslationCorrect()) {
            answeredQuestion.setDifficulty(answeredQuestion.getDifficulty() / 2);
        }
        OldQuestion question = new  OldQuestion(answeredQuestion);
        questionRepository.save(question);
    }

    @Override
    public Noun generateNoun() {
        return new Noun("Sonne", "sun", "The sun is shining.", "die");
    }

}
