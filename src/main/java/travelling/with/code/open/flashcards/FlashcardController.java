package travelling.with.code.open.flashcards;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import travelling.with.code.open.flashcards.dao.AnsweredQuestion;
import travelling.with.code.open.flashcards.dao.Question;
import travelling.with.code.open.flashcards.dao.QuestionsRepository;
import travelling.with.code.open.flashcards.questioner.Questioner;

@Controller
public class FlashcardController {

	@Autowired
	private Questioner questioner;

	@Autowired
	private QuestionsRepository repository;

	@RequestMapping(value="/flashcards", method=RequestMethod.GET)
	public String index() {
	    return "index";
	}

	@RequestMapping(value="/flashcards-add", method=RequestMethod.GET)
	public String add(Model model) {
	    model.addAttribute("question", new Question());
	    return "add";
	}

	@RequestMapping(value="flashcards-add", method=RequestMethod.POST)
	public String add(@ModelAttribute("question") Question question, Model model) {
	    if (repository.exists(question.getWord())) {
	        model.addAttribute("addResult", "error");
	        model.addAttribute("errorMessage", "The word '" + question.getWord() + "' already exists.");
	    } else {
	        repository.insert(question);
	        model.addAttribute("addResult", "success");
	        model.addAttribute("successMessage", "The word '" + question.getWord() + "' was successfully added in the database");
	    }
	    model.addAttribute("question", new Question());
	    return "add";
	}

	@RequestMapping(value="/flashcards-test", method=RequestMethod.GET)
    public String test(Model model) {
		Optional<Question> question = questioner.generateQuestion();
        model.addAttribute("question", new AnsweredQuestion(question.get()));
        return "question";
	}

	@RequestMapping(value="/flashcards-test", method=RequestMethod.POST)
    public String testEvaluate(@ModelAttribute("question") AnsweredQuestion question, Model model) {
	    question.setIsArticleCorrect(question.getArticle().equalsIgnoreCase(question.getUserArticle()) ? true : false);
	    question.setIsTranslationCorrect(question.getTranslation().equalsIgnoreCase(question.getUserTranslation()) ? true : false);
	    questioner.evaluateQuestion(question);
		model.addAttribute("question", question);
		return "answer";
    }

}