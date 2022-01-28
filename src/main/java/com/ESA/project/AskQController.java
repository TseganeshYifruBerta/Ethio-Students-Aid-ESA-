package com.ESA.project;
// import com.ESA.project.AsqQController.AskQ;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.stream.Collectors;

// import org.hibernate.validator.internal.util.logging.Log;
// import org.jboss.logging.BasicLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
// import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;

import javax.validation.Valid;

// import lombok.extern.slf4j.Slf4j;
@Controller
// @Slf4j
// @SessionAttributes("ProvideAnswer")
public class AskQController {
    // private static final BasicLogger log = null;
    // private static final String AskQ = null;
    @Autowired

    private AskQRepository qsnrepository;
    @Autowired
    private UserRepository userrepository;

    @GetMapping("/AskQ")
    public ModelAndView showAllQuestions() {
        ModelAndView viewqsn = new ModelAndView("ProvideAnswer");
        ModelAndView noqsn=new ModelAndView("noquestions");
        List<AskQ> listofqsn = qsnrepository.findAll();
        viewqsn.addObject("AskQ", listofqsn);
        if (listofqsn.isEmpty()){
            return noqsn;
        }
        else{
            return viewqsn;
        }
        
    }
    @GetMapping("/view")
    public ModelAndView showAllanswersQuestions() {
        ModelAndView viewqsnans = new ModelAndView("ViewAnswer");
        ModelAndView none = new ModelAndView("noquestions");

        List<AskQ> listofqsn = qsnrepository.findAll();
        viewqsnans.addObject("AskQ", listofqsn);

        if (listofqsn.isEmpty()){
            return none;

        }
        else{
        return viewqsnans;
        }
    }
    @GetMapping("/members")
    public ModelAndView showAllmembers() {
        ModelAndView viewmembers = new ModelAndView("profile");
        List<User> listofqsn = userrepository.findAll();
        viewmembers.addObject("User", listofqsn);
        return viewmembers;
    }

    @GetMapping("/addForm")
    public ModelAndView addQuestionForm() {
        ModelAndView newForm = new ModelAndView("AskQ");
        AskQ newQuestion = new AskQ();
        newForm.addObject("AskQ", newQuestion);
        return newForm;
    }

    @PostMapping("/saveQsn")
    public String saveQuestions(@Valid AskQ AskQ,@ModelAttribute AskQ Askq,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "questionForm";
        }
        this.qsnrepository.save(Askq);
        return "redirect:/success";
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long userId) {
        ModelAndView mav = new ModelAndView("questionForm");
        AskQ questionQ = qsnrepository.findById(userId).get();
        mav.addObject("AskQ", questionQ);
        return mav;
    }
    // public void deleteupdatequestion(@RequestParam Long userId){
    // qsnrepository.deleteById(userId);
    // }

    @GetMapping("/deletequestion")
    public String deletequestion(@RequestParam Long userId) {
        qsnrepository.deleteById(userId);

        return "redirect:/AskQ";

    }
    // @Autowired

    // private questionFormRepository answerrepository;

    // @GetMapping("/AnswerQsn")
    // public ModelAndView showAllAnswers(){
    // ModelAndView answerqsn = new ModelAndView("ProvideAnswer");
    // List<questionForm> listofanswer = answerrepository.findAll();
    // answerqsn.addObject("questionForm",listofanswer);
    // return answerqsn;
    // }

    // @GetMapping("/addAnswer")
    // public ModelAndView addanswerForm(){
    // ModelAndView answerForm = new ModelAndView("questionForm");
    // AskQ newAnswer = new AskQ();
    // answerForm.addObject("questionForm", newAnswer);
    // return answerForm;
    // }
    @GetMapping("/UpdateForm")
    public ModelAndView UpdateForm(@RequestParam Long userId) {
        ModelAndView mav = new ModelAndView("questionForm");
        AskQ questionQ = qsnrepository.findById(userId).get();
        mav.addObject("questionForm", questionQ);
        return mav;
    }
    // @GetMapping("/answers")
    // public ModelAndView UpdateAnswer(@RequestParam Long userId){
    // ModelAndView mav = new ModelAndView("ProvideAnswer");
    // AskQ answerQ = answerrepository.findById(userId).get();
    // mav.addObject("ProvideAnswer", answerQ);
    // return mav;
    // }

    // @PostMapping("/answersaveQsn")
    // public String answersaveQuestions (@ModelAttribute AskQ Askq){
    // qsnrepository.save(Askq);
    // return "redirect:/ProvideAnswer";
    // }

    // @PostMapping("/saveAnswer")
    // public String saveAnswer (@ModelAttribute AskQ Answer){
    // qsnrepository.save(Answer);
    // return "redirect:/ProvideAnswer";
    // }
    @GetMapping("/viewAnswer")
    public ModelAndView showAllanswer() {
        ModelAndView viewanswer = new ModelAndView("ProvideAnswer");
        List<AskQ> listofqsn = qsnrepository.findAll();
        viewanswer.addObject("AskQ", listofqsn);
        return viewanswer;
    }

    // @GetMapping("/answer")
    // public ModelAndView answer(@RequestParam Long userId){
    // ModelAndView mav = new ModelAndView("ViewAnswer");
    // AskQ questionQ = qsnrepository.findById(userId).get();
    // mav.addObject("ViewAnswer", questionQ);
    // return mav;
    // }

    @GetMapping("/searchquestion")
    public ModelAndView searchquestion() {
        ModelAndView searchqsn = new ModelAndView("searchquestions");
        searchqsn.addObject("query", new SearchQuery());
        return searchqsn;
    }

    @PostMapping(path = "/search")
    public ModelAndView search(@ModelAttribute("query") SearchQuery questions) {

        ModelAndView model = new ModelAndView("searched");
        ModelAndView nomessage=new ModelAndView("nomessage");
        // Object query;

        List<AskQ> Askq = qsnrepository.findByType(questions.getType());
        model.addObject("AskQ", Askq);
        if (Askq.isEmpty()){
            return nomessage;
        }
        // model.addObject("AskQ", Askq);
        else{
            return model;
        }
       
    }


    @GetMapping("/showprofile")
    public ModelAndView showProfile(@RequestParam Long userId) {
        ModelAndView mav = new ModelAndView("ProfilePage");
        User userp = userrepository.findById(userId).get();
        mav.addObject("User", userp);
        return mav;
    }
//     @PostMapping(path = "/usersearch")
//     public ModelAndView usersearch(@ModelAttribute("user") SearchQuery user) {

//         ModelAndView model = new ModelAndView("ProfilePage");
//         ModelAndView nomessage=new ModelAndView("nomessage");
//         // Object query;

//         User userp = userrepository.findByUsername(user.getUsername());
//         model.addObject("User", userp);
//         // model.addObject("AskQ", Askq);
//         return model;
        

// }
}