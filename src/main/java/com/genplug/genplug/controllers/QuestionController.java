package com.genplug.genplug.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.genplug.genplug.classes.*;
import com.genplug.genplug.repositories.ProfessionRepository;
import com.genplug.genplug.repositories.QuestionRepository;
import com.genplug.genplug.services.QuestionService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    ProfessionRepository professionRepository;


    @PostMapping(path = "/questions/add", produces = "application/json; charset = UTF-8")
    @ResponseBody
    public Question addQuestion(@RequestBody ObjectNode objectNode){
        String question = objectNode.get("question").asText();
        String professionName = objectNode.get("profession").asText();

        Question question1 = new Question();

        List<Profession> professionList = (List<Profession>) professionRepository.findAll();
        for (Profession profession:professionList
        ) {
            if (profession.getName().equals(professionName)){
                question1.setProfession(profession);
            }
        }

        question1.setQuestion(question);

        questionService.addQuestion(question1);
        return question1;
    }

    @PostMapping(path = "/question/{id}/answer", produces="application/json; charset=UTF-8")
    @ResponseBody
    public Question answerQuestion(@PathVariable("id") Long questionId, @RequestBody ObjectNode objectNode){
        String answer = objectNode.get("answer").asText();
        Question foundQuestion = questionRepository.findById(questionId).get();
        foundQuestion.setAnswer(answer);
        questionRepository.save(foundQuestion);
        return foundQuestion;

    }

    @GetMapping(path = "/question/all", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<Question> getAllQuestions(){
        return questionService.viewAllQuestions();
    }

    @GetMapping(path="/question/{id}",produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Question viewOneQuestion(@PathVariable("id") Long questionId){
        return questionService.viewOneQuestion(questionId);
    }


}
