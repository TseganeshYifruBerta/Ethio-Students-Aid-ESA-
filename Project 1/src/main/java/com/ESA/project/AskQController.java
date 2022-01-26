package com.ESA.project;
// import com.ESA.project.AsqQController.AskQ;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.stream.Collectors;


// import org.hibernate.validator.internal.util.logging.Log;
// import org.jboss.logging.BasicLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;



// import lombok.extern.slf4j.Slf4j;
@Controller
// @Slf4j
// @SessionAttributes("ProvideAnswer")
public class AskQController {
    // private static final BasicLogger log = null;
    // private static final String AskQ = null;
    @Autowired
    
    private AskQRepository qsnrepository;
    // @Autowired
    // private AnswerRepository answerrepository;

   @GetMapping("/AskQ")
   public ModelAndView showAllQuestions(){
    ModelAndView viewqsn = new ModelAndView("ProvideAnswer");
    List<AskQ> listofqsn = qsnrepository.findAll();
    viewqsn.addObject("AskQ",listofqsn);
    return viewqsn;
   }

   @GetMapping("/addForm")
   public ModelAndView  addQuestionForm(){
    ModelAndView newForm = new ModelAndView("AskQ");
    AskQ newQuestion = new AskQ();
    newForm.addObject("AskQ", newQuestion);
    return newForm;
   }
   
   @PostMapping("/saveQsn")
    public String saveQuestions (@ModelAttribute AskQ Askq){
        qsnrepository.save(Askq);
        return "redirect:/AskQ";
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long userId){
        ModelAndView mav = new ModelAndView("questionForm");
        AskQ questionQ = qsnrepository.findById(userId).get();
        mav.addObject("AskQ", questionQ);
        return mav;
    }
    // public void deleteupdatequestion(@RequestParam Long userId){
    //     qsnrepository.deleteById(userId);
    // }



    @GetMapping("/deletequestion")
    public String deletequestion(@RequestParam Long userId){
        qsnrepository.deleteById(userId);
 
        return "redirect:/AskQ";
    
    }
//     @Autowired
    
//     private questionFormRepository answerrepository;

//    @GetMapping("/AnswerQsn")
//    public ModelAndView showAllAnswers(){
//     ModelAndView answerqsn = new ModelAndView("ProvideAnswer");
//     List<questionForm> listofanswer = answerrepository.findAll();
//     answerqsn.addObject("questionForm",listofanswer);
//     return answerqsn;
//    }

//    @GetMapping("/addAnswer")
//    public ModelAndView  addanswerForm(){
//     ModelAndView answerForm = new ModelAndView("questionForm");
//     AskQ newAnswer = new AskQ();
//     answerForm.addObject("questionForm", newAnswer);
//     return answerForm;
//    }
   @GetMapping("/UpdateForm")
   public ModelAndView UpdateForm(@RequestParam Long userId){
       ModelAndView mav = new ModelAndView("questionForm");
       AskQ questionQ = qsnrepository.findById(userId).get();
       mav.addObject("questionForm", questionQ);
       return mav;
   }
//    @GetMapping("/answers")
//    public ModelAndView UpdateAnswer(@RequestParam Long userId){
//        ModelAndView mav = new ModelAndView("ProvideAnswer");
//        AskQ answerQ = answerrepository.findById(userId).get();
//        mav.addObject("ProvideAnswer", answerQ);
//        return mav;
//    }


//    @PostMapping("/answersaveQsn")
//    public String answersaveQuestions (@ModelAttribute AskQ Askq){
//        qsnrepository.save(Askq);
//        return "redirect:/ProvideAnswer";
//    }

//    @PostMapping("/saveAnswer")
//    public String saveAnswer (@ModelAttribute AskQ Answer){
//        qsnrepository.save(Answer);
//        return "redirect:/ProvideAnswer";
//    }
@GetMapping("/viewAnswer")
public ModelAndView showAllanswer(){
    ModelAndView viewanswer = new ModelAndView("ProvideAnswer");
    List<AskQ> listofqsn = qsnrepository.findAll();
    viewanswer.addObject("AskQ",listofqsn);
    return viewanswer;
   }
   
//    @GetMapping("/answer")
//    public ModelAndView answer(@RequestParam Long userId){
//        ModelAndView mav = new ModelAndView("ViewAnswer");
//        AskQ questionQ = qsnrepository.findById(userId).get();
//        mav.addObject("ViewAnswer", questionQ);
//        return mav;
//    }


@GetMapping("/searchquestion")
public ModelAndView searchquestion(){
    ModelAndView searchqsn=new ModelAndView("searchquestions");
    searchqsn.addObject("query",new SearchQuery());
    return searchqsn;
}

@PostMapping(path="/search")
public ModelAndView search(@ModelAttribute("query") SearchQuery questions){
    ModelAndView model=new ModelAndView("searched");
    // Object query;

    List<AskQ> Askq=qsnrepository.findByType(questions.getType());
    model.addObject("AskQ",Askq);
    return model;
}

}