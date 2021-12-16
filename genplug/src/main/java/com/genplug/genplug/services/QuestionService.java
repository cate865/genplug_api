package com.genplug.genplug.services;

import com.genplug.genplug.classes.Question;
import com.genplug.genplug.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    // create/add question
    public void addQuestion(Question question){
        questionRepository.save(question);
    }

    // answer question
    public Question answerQuestion(Long questionId, String answer){
        Question questionToAnswer = questionRepository.findById(questionId).get();
        questionToAnswer.setAnswer(answer);
        questionRepository.save(questionToAnswer);
        return questionToAnswer;
    }

    //view all questions
    public List<Question> viewAllQuestions(){
        return (List<Question>) questionRepository.findAll();

    }

    //view one question
    public Question viewOneQuestion(Long questionId){
        return questionRepository.findById(questionId).get();
    }
}
