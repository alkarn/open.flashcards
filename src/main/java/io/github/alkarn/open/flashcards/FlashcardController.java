package io.github.alkarn.open.flashcards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.github.alkarn.open.flashcards.dao.AdjectiveDto;
import io.github.alkarn.open.flashcards.dao.AdjectiveQuestion;
import io.github.alkarn.open.flashcards.dao.AdjectiveRepository;
import io.github.alkarn.open.flashcards.dao.AdverbDto;
import io.github.alkarn.open.flashcards.dao.AdverbQuestion;
import io.github.alkarn.open.flashcards.dao.AdverbRepository;
import io.github.alkarn.open.flashcards.dao.NounDto;
import io.github.alkarn.open.flashcards.dao.NounQuestion;
import io.github.alkarn.open.flashcards.dao.NounRepository;
import io.github.alkarn.open.flashcards.dao.VerbDto;
import io.github.alkarn.open.flashcards.dao.VerbQuestion;
import io.github.alkarn.open.flashcards.dao.VerbRepository;
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
    private AdjectiveRepository adjectiveRepository;

    @Autowired
    private VerbRepository verbRepository;

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

    @RequestMapping(value = "/flashcards/add/adjectives", method = RequestMethod.GET)
    public String addAdjectiveForm(Model model) {
        model.addAttribute("adjective", new AdjectiveDto());
        return "addAdjectives";
    }

    @RequestMapping(value="/flashcards/add/adjectives", method=RequestMethod.POST)
    public String addAdjectiveSubmit(Model model, @ModelAttribute AdjectiveDto newAdjective) {
        addWordSubmit(model, newAdjective);
        return "addAdjectives";
    }

    @RequestMapping(value = "/flashcards/add/verbs", method = RequestMethod.GET)
    public String addVerbForm(Model model) {
        model.addAttribute("verb", new VerbDto());
        return "addVerbs";
    }

    @RequestMapping(value="/flashcards/add/verbs", method=RequestMethod.POST)
    public String addVerbSubmit(Model model, @ModelAttribute VerbDto newVerb) {
        addWordSubmit(model, newVerb);
        return "addVerbs";
    }

    public void addWordSubmit(Model model, WordDto newWord) {
        if (evaluator.isValid(newWord)) {
            if (newWord instanceof NounDto) {
                nounRepository.save(transformer.transform((NounDto) newWord));
                model.addAttribute("noun", new NounDto());
            } else if (newWord instanceof AdverbDto) {
                adverbRepository.save(transformer.transform((AdverbDto) newWord));
                model.addAttribute("adverb", new AdverbDto());
            } else if (newWord instanceof AdjectiveDto) {
                adjectiveRepository.save(transformer.transform((AdjectiveDto) newWord));
                model.addAttribute("adjective", new AdjectiveDto());
            } else if (newWord instanceof VerbDto) {
                verbRepository.save(transformer.transform((VerbDto) newWord));
                model.addAttribute("verb", new VerbDto());
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
            } else if (newWord instanceof AdjectiveDto) {
                model.addAttribute("adjective", newWord);
            } else if (newWord instanceof VerbDto) {
                model.addAttribute("verb", newWord);
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

    @RequestMapping(value = "/flashcards/test/adverbs", method = RequestMethod.GET)
    public String testAdverbForm(Model model) {
        questioner.generateAdverbQuestion().ifPresent(q -> model.addAttribute("adverbQuestion", q));
        return "testAdverbs";
    }

    @RequestMapping(value = "/flashcards/test/adverbs", method = RequestMethod.POST)
    public String testAdverbSubmit(Model model, @ModelAttribute AdverbQuestion adverbQuestion) throws Exception {
        model.addAttribute("adverbQuestion", adverbQuestion);
        model.addAttribute("testResult", evaluator.evaluateUserAnswer(adverbQuestion));
        return "testAdverbs";
    }

    @RequestMapping(value = "/flashcards/test/adjectives", method = RequestMethod.GET)
    public String testAdjectiveForm(Model model) {
        questioner.generateAdjectiveQuestion().ifPresent(q -> model.addAttribute("adjectiveQuestion", q));
        return "testAdjectives";
    }

    @RequestMapping(value = "/flashcards/test/adjectives", method = RequestMethod.POST)
    public String testAdjectiveSubmit(Model model, @ModelAttribute AdjectiveQuestion adjectiveQuestion) throws Exception {
        model.addAttribute("adjectiveQuestion", adjectiveQuestion);
        model.addAttribute("testResult", evaluator.evaluateUserAnswer(adjectiveQuestion));
        return "testAdjectives";
    }

    @RequestMapping(value = "/flashcards/test/verbs", method = RequestMethod.GET)
    public String testVerbForm(Model model) {
        questioner.generateVerbQuestion().ifPresent(q -> model.addAttribute("verbQuestion", q));
        return "testVerbs";
    }

    @RequestMapping(value = "/flashcards/test/verbs", method = RequestMethod.POST)
    public String testVerbSubmit(Model model, @ModelAttribute VerbQuestion verbQuestion) throws Exception {
        model.addAttribute("verbQuestion", verbQuestion);
        model.addAttribute("testResult", evaluator.evaluateUserAnswer(verbQuestion));
        return "testVerbs";
    }

}