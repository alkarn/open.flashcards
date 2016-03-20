package travelling.with.code.open.flashcards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import travelling.with.code.open.flashcards.questioner.Questioner;

@Controller
public class GreetingController {

	@Autowired
	private Questioner questioner;

	@RequestMapping("/flashcards")
    public String flashCards(Model model) {
        model.addAttribute("word", questioner.generateQuestion().getForeignWord());
        return "flashcards";
    }

}