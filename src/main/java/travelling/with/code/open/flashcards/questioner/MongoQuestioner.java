package travelling.with.code.open.flashcards.questioner;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import travelling.with.code.open.flashcards.dao.AnsweredQuestion;
import travelling.with.code.open.flashcards.dao.Question;
import travelling.with.code.open.flashcards.dao.QuestionsRepository;

@Component
public class MongoQuestioner implements Questioner {

    @Autowired
    private QuestionsRepository questionRepository;

    private Set<Question> bufferedQuestions = new HashSet<>();
    private Iterator<Question> questionIterator = bufferedQuestions.iterator();

	@Override
	public Optional<Question> generateQuestion() {
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
    public void evaluateQuestion(AnsweredQuestion answeredQuestion) {
        if (answeredQuestion.getDifficulty() < (Question.MAX_DIFFICULTY - Question.MIN_DIFFICULTY) * 1 / 10) {
            answeredQuestion.setDifficulty((Question.MAX_DIFFICULTY - Question.MIN_DIFFICULTY) / 2);
        }
        if (answeredQuestion.getIsArticleCorrect()) {
            answeredQuestion.setDifficulty(answeredQuestion.getDifficulty() * 4 / 5);
        }
        if (answeredQuestion.getIsTranslationCorrect()) {
            answeredQuestion.setDifficulty(answeredQuestion.getDifficulty() / 2);
        }
        Question question = new  Question(answeredQuestion);
        questionRepository.save(question);
    }

}
