package com.application.quiz.vo;

import com.application.quiz.entities.Answer;
import com.application.quiz.entities.Question;

import java.util.List;

public class UserVo {
    private Long id;
    private String user_type;
    private List<Question> questions;
    private List<Answer> answers;

    public UserVo(Long id, String user_type, List<Question> questions, List<Answer> answers) {
        this.id = id;
        this.user_type = user_type;
        this.questions = questions;
        this.answers = answers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
