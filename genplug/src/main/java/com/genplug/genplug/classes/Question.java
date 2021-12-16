package com.genplug.genplug.classes;

import javax.persistence.*;

@Entity
@Table(name="questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "question_id")
    private Long questionId;

    @Column(name="question")
    private String question;

    @Column(name="answer",length = 600)
    private String answer;

    @OneToOne
    @JoinColumn(name="profession_id")
    private Profession profession;

//    @OneToOne
//    @JoinColumn(name="email")
//    private Professional professionalWhoAnswered;

    public Question() {
    }

    public Question(String question, String answer, Profession profession, Professional professionalWhoAnswered) {
        this.question = question;
        this.answer = answer;
        this.profession = profession;
        //this.professionalWhoAnswered = professionalWhoAnswered;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

//    public Professional getProfessionalWhoAnswered() {
//        return professionalWhoAnswered;
//    }
//
//    public void setProfessionalWhoAnswered(Professional professionalWhoAnswered) {
//        this.professionalWhoAnswered = professionalWhoAnswered;
//    }
}
