package io.github.alkarn.open.flashcards;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.github.alkarn.open.flashcards.dao.Noun;
import io.github.alkarn.open.flashcards.dao.NounQuestion;
import io.github.alkarn.open.flashcards.dao.OldQuestion;
import io.github.alkarn.open.flashcards.dao.OldQuestionsRepository;
import io.github.alkarn.open.flashcards.questioner.Questioner;

@Controller
public class FlashcardController {

	@Autowired
	private Questioner questioner;

	@Autowired
	private OldQuestionsRepository repository;

	@RequestMapping(value="/flashcards", method=RequestMethod.GET)
	public String index() {
	    return "index";
	}

	@RequestMapping(value="/flashcards-add", method=RequestMethod.GET)
	public String add(Model model) {
	    model.addAttribute("question", new OldQuestion());
	    return "add";
	}

//	@RequestMapping(value="flashcards-add", method=RequestMethod.POST)
//	public String add(@ModelAttribute("question") OldQuestion question, Model model) {
//	    if (repository.exists(question.getWord())) {
//	        model.addAttribute("addResult", "error");
//	        model.addAttribute("errorMessage", "The word '" + question.getWord() + "' already exists.");
//	    } else {
//	        repository.insert(question);
//	        model.addAttribute("addResult", "success");
//	        model.addAttribute("successMessage", "The word '" + question.getWord() + "' was successfully added in the database");
//	    }
//	    model.addAttribute("question", new OldQuestion());
//	    return "add";
//	}

	@RequestMapping(value="/flashcards-test", method=RequestMethod.GET)
    public String test(Model model) {
//		Noun noun = questioner.generateNoun();
//		Question<Noun> question = new Question<Noun>(noun);
	    Noun noun = new Noun("Sonne", "sun", "The sun is shining.", "die");
	    NounQuestion question = new NounQuestion(noun);
        model.addAttribute("question", question);
        return "question-noun";
	}

	@RequestMapping(value="/flashcards-test", method=RequestMethod.POST)
    public String testEvaluate(Model model, HttpServletRequest request, @ModelAttribute("question") NounQuestion question) {
//	    question.setIsArticleCorrect(question.getArticle().equalsIgnoreCase(question.getUserArticle()) ? true : false);
//	    question.setIsTranslationCorrect(question.getTranslation().equalsIgnoreCase(question.getUserTranslation()) ? true : false);
//	    questioner.evaluateQuestion(question);
//		model.addAttribute("question", question);
	    Enumeration<String> parameterNames = request.getParameterNames();
	    while (parameterNames.hasMoreElements()) {
	        String parameter = parameterNames.nextElement();
	        System.out.println(parameter + " : " + request.getParameter(parameter));
	    }
	    System.out.println("--------------- hola");

		return "answer-mufa";
    }
//	@RequestMapping(value="/flashcards-test", method=RequestMethod.GET)
//	public String test(Model model) {
//	    Optional<OldQuestion> question = questioner.generateQuestion();
//	    model.addAttribute("question", new OldAnsweredQuestion(question.get()));
//	    return "question";
//	}
//
//	@RequestMapping(value="/flashcards-test", method=RequestMethod.POST)
//	public String testEvaluate(@ModelAttribute("question") OldAnsweredQuestion question, Model model) {
//	    question.setIsArticleCorrect(question.getArticle().equalsIgnoreCase(question.getUserArticle()) ? true : false);
//	    question.setIsTranslationCorrect(question.getTranslation().equalsIgnoreCase(question.getUserTranslation()) ? true : false);
//	    questioner.evaluateQuestion(question);
//	    model.addAttribute("question", question);
//	    return "answer";
//	}

}