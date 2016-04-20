package travelling.with.code.open.flashcards.questioner;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import travelling.with.code.open.flashcards.dao.Question;
import travelling.with.code.open.flashcards.dao.QuestionsRepository;

@Component
public class SimpleQuestioner implements Questioner {

    @Autowired
    private QuestionsRepository wordRepository;

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
	    bufferedQuestions.addAll(wordRepository.findAll());
	    questionIterator = bufferedQuestions.iterator();
	}

    @Override
    public void evaluateAnswer(String word, boolean result) {
    }

}
