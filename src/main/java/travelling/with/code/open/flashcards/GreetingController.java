package travelling.with.code.open.flashcards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import travelling.with.code.open.flashcards.questioner.Answer;
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
        Answer answer = new Answer();
        model.addAttribute("answer", answer);
        return "bootstrap-flashcards";
	}

	@RequestMapping(value="/flashcards", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute("questionArticle") String questionArticle, @ModelAttribute("questionTranslation") String questionTranslation,
    		@ModelAttribute("question") SimpleQuestion question, @ModelAttribute("answer") Answer answer, Model model) {

		if (questionArticle.equals(answer.getArticle())) {
			answer.setIsArticleCorrect(true);
		} else {
			System.err.println("Wrong article");
			answer.setIsArticleCorrect(false);;
		}
		if (questionArticle.equals(answer.getTranslation())) {
			answer.setIsTranslationCorrect(true);
		} else {
			answer.setIsTranslationCorrect(false);
			System.err.println();
		}
		model.addAttribute("question", question);
		model.addAttribute("answer", answer);

		return "bootstrap-flashcards";
    }

}