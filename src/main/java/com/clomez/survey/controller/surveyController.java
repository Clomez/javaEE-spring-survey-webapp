package com.clomez.survey.controller;

import com.clomez.survey.DAO.SurveyDAO;
import com.clomez.survey.beans.Answer;
import com.clomez.survey.beans.Question;
import com.clomez.survey.beans.Survey;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clomez on 27.5.2017.
 */

@Controller
public class surveyController {

    SurveyDAO surveyDAO = new SurveyDAO();
    Survey surveyS = new Survey();
    Answer answerS = new Answer();
    List<Integer> help = new ArrayList<>();

    //INDEX
    @RequestMapping("/")
    public String home() {
        return "index";
    }

    //SHOW SURVEYS
    @RequestMapping("/survey")
    public String survey(@RequestParam(value="id", required = false, defaultValue = "1") int id, Model model){

        List<Question> survey = surveyDAO.getSurveyById(id);
        //SET ID TO SURVEY
        surveyS.setId(id);
        for (int i=0; i<survey.size();i++){
            help.add(survey.get(i).getId());
        }
        model.addAttribute("survey", survey);
        return "showSurvey";

    }

    //POST ANSWERS
    @RequestMapping(value = "/saveAnswer", method = RequestMethod.POST)
    public String saveAnswer(@RequestParam("answer")List<String> answerL){

            //SET SURVEY ID TO ANSWER
            int idS = surveyS.getId();
            answerS.setAnswer_group(idS);

            for (int i = 0; i<answerL.size(); i++) {
                //SET VALUE FOR ANSWER
                answerS.setName(answerL.get(i));
                //SET QUESTION ID TO ANSWE
                answerS.setQuestion_id(help.get(i));
                //SET SAVE ANSWER
                surveyDAO.saveAnserws(answerS);
            }
            return "thanks";

    }

    // CREATE NEW SURVEY PAGE
    @RequestMapping("/createSurvey")
    public String createNew (){

        return "createSurvey";

    }

    //CREATE THE ACTUAL SURVEY POST
    @RequestMapping(value = "/addSurvey", method = RequestMethod.POST)
    public String addSurvey(@ModelAttribute("name")String name){
        int id = surveyDAO.getHighestId()+1;
        surveyS.setId(id);
        surveyS.setName(name);
        surveyS.setEnabled(true);
        surveyDAO.saveSurvey(surveyS);
        return "redirect:/createQuestion?id=" + id;
    }

    //CREATE QUESTIONS PAGE
    @RequestMapping("/createQuestion")
    public String createSurvey(@RequestParam(value="id", required = false, defaultValue = "1") int id, Model model){
        List<Question> survey = surveyDAO.getSurveyById(id);
        model.addAttribute("survey", survey);
        return "addQuestion";
    }

    //CREATE ACTUAL QUESTION
    @RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
    public String addQuestion(Model model, @ModelAttribute("question")String question){
        Question questionS = new Question();
        int id = surveyS.getId();
        questionS.setSurveyid(id);
        questionS.setName(question);
        surveyDAO.saveQuestions(questionS);

        List<Question> survey = surveyDAO.getSurveyById(id);
        model.addAttribute("survey", survey);

        return "redirect:/createQuestion?id=" + id;
    }

}
