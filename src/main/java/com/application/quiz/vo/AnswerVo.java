package com.application.quiz.vo;

import com.application.quiz.entities.Question;
import com.application.quiz.entities.User;

import java.time.LocalDateTime;

public class AnswerVo {
    private Long id;
    private String answer;
    private String topic;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    private Question question;
    private User user;
    private Long user_id;
    private Long question_id;

    public AnswerVo(Long id, String answer, String topic, LocalDateTime createdTime, LocalDateTime updatedTime,
                    Question question, User user, Long user_id, Long question_id) {
        this.id = id;
        this.answer = answer;
        this.topic = topic;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
        this.question = question;
        this.user = user;
        this.user_id = user_id;
        this.question_id = question_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Long question_id) {
        this.question_id = question_id;
    }
}
