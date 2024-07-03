package com.application.quiz.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String user_type; //respondent questioner
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Question> questions;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Answer> answers;

    public User(){}

    public User(Long id, String user_type, List<Question> questions, List<Answer> answers) {
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
