package travelling.with.code.open.flashcards.questioner;

import org.springframework.stereotype.Component;

@Component
public class SimpleQuestioner implements Questioner {

	@Override
	public Question generateQuestion() {
		Question question = new SimpleQuestion("Sonne", "Sun", "", "die", "Nature");
		return question;
	}

}
