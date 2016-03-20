package travelling.with.code.open.flashcards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import travelling.with.code.open.flashcards.questioner.Question;
import travelling.with.code.open.flashcards.questioner.Questioner;
import travelling.with.code.open.flashcards.questioner.SimpleQuestion;

@Controller
public class GreetingController {

	@Autowired
	private Questioner questioner;

	@RequestMapping(value="/flashcards", method=RequestMethod.GET)
    public String flashCards(Model model) {
		Question question = questioner.generateQuestion();
        model.addAttribute("question", question);
        return "bootstrap-flashcards";
	}

	@RequestMapping(value="/flashcards", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute SimpleQuestion question, Model model) {
		model.addAttribute("answer", question.getAnswer());
        return "answer";
    }

}