package com.application.quiz.vo;

import com.application.quiz.entities.Answer;
import com.application.quiz.entities.User;

import java.time.LocalDateTime;
import java.util.List;

public class QuestionVo {
    private Long id;
    private String question;
    private String topic;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    private List<Answer> answers;
    private User user;
    private Long user_id;

    public QuestionVo(Long id, String question, String topic, LocalDateTime createdTime, LocalDateTime updatedTime,
                      List<Answer> answers, User user, Long user_id) {
        this.id = id;
        this.question = question;
        this.topic = topic;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
        this.answers = answers;
        this.user = user;
        this.user_id = user_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
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

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
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
}
