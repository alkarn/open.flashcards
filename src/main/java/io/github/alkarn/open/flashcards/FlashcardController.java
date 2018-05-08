package io.github.alkarn.open.flashcards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.github.alkarn.open.flashcards.dao.AdverbDto;
import io.github.alkarn.open.flashcards.dao.AdverbRepository;
import io.github.alkarn.open.flashcards.dao.NounDto;
import io.github.alkarn.open.flashcards.dao.NounQuestion;
import io.github.alkarn.open.flashcards.dao.NounRepository;
import io.github.alkarn.open.flashcards.dao.WordDto;
import io.github.alkarn.open.flashcards.questioner.Questioner;
import io.github.alkarn.utils.AddResult;
import io.github.alkarn.utils.Evaluator;
import io.github.alkarn.utils.Transformer;

@Controller
public class FlashcardController {

    @Autowired
    private NounRepository nounRepository;

    @Autowired
    private AdverbRepository adverbRepository;

	@Autowired
	private Evaluator evaluator;

	@Autowired
	private Transformer transformer;

	@Autowired
	private Questioner questioner;

	@RequestMapping(value="/flashcards", method=RequestMethod.GET)
	public String index() {
	    return "index";
	}

	@RequestMapping(value="/flashcards/add", method=RequestMethod.GET)
	public String add(Model model) {
	    return "add";
	}

	@RequestMapping(value="/flashcards/add/nouns", method=RequestMethod.GET)
	public String addNounForm(Model model) {
	    model.addAttribute("noun", new NounDto());
	    return "addNouns";
	}

	@RequestMapping(value="/flashcards/add/nouns", method=RequestMethod.POST)
    public String addNounSubmit(Model model, @ModelAttribute NounDto newNoun) {
	    addWordSubmit(model, newNoun);
	    return "addNouns";
    }

    @RequestMapping(value = "/flashcards/add/adverbs", method = RequestMethod.GET)
    public String addAdverbForm(Model model) {
        model.addAttribute("adverb", new AdverbDto());
        return "addAdverbs";
    }

    @RequestMapping(value="/flashcards/add/adverbs", method=RequestMethod.POST)
    public String addAdverbSubmit(Model model, @ModelAttribute AdverbDto newAdverb) {
        addWordSubmit(model, newAdverb);
        return "addAdverbs";
    }

    public void addWordSubmit(Model model, WordDto newWord) {
        if (evaluator.isValid(newWord)) {
            if (newWord instanceof NounDto) {
                nounRepository.save(transformer.transform((NounDto) newWord));
                model.addAttribute("noun", new NounDto());
            } else if (newWord instanceof AdverbDto) {
                adverbRepository.save(transformer.transform((AdverbDto) newWord));
                model.addAttribute("adverb", new AdverbDto());
            }
            model.addAttribute(AddResult.ADD_RESULT, AddResult.SUCCESS);
            model.addAttribute(AddResult.SUCCESS_MESSAGE, evaluator.getSuccessMessage(newWord));
        } else {
            model.addAttribute(AddResult.ADD_RESULT, AddResult.ERROR);
            model.addAttribute(AddResult.ERROR_MESSAGE, evaluator.getErrorMessage(newWord));
            if (newWord instanceof NounDto) {
                model.addAttribute("noun", newWord);
            } else if (newWord instanceof AdverbDto) {
                model.addAttribute("adverb", newWord);
            }
        }
    }

	@RequestMapping(value="/flashcards/test", method=RequestMethod.GET)
    public String test(Model model) {
        return "test";
    }

	@RequestMapping(value="/flashcards/test/nouns", method=RequestMethod.GET)
    public String testNounForm(Model model) {
        questioner.generateNounQuestion().ifPresent(q -> model.addAttribute("nounQuestion", q));
        return "testNouns";
	}

	@RequestMapping(value="/flashcards/test/nouns", method=RequestMethod.POST)
	public String testNounSubmit(Model model, @ModelAttribute NounQuestion nounQuestion) throws Exception {
	    model.addAttribute("nounQuestion", nounQuestion);
	    model.addAttribute("testResult", evaluator.evaluateUserAnswer(nounQuestion));
	    return "testNouns";
	}

}