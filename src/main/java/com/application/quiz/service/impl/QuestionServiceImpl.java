package com.application.quiz.service.impl;

import com.application.quiz.entities.Question;
import com.application.quiz.entities.User;
import com.application.quiz.exception.UserNotFound;
import com.application.quiz.repositories.QuestionRepository;
import com.application.quiz.repositories.UserRepository;
import com.application.quiz.service.QuestionService;
import com.application.quiz.vo.QuestionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository, UserRepository userRepository) {
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public String addQuestion(QuestionVo questionVo) {
        User user = userRepository.findById(questionVo.getUser_id()).orElseThrow(() ->
                new UserNotFound("User not found for this id" ));
        if(user.getUser_type().equalsIgnoreCase("Questioner")) {
            Question question = new Question();
            question.setId(questionVo.getId());
            question.setAnswers(questionVo.getAnswers());
            question.setTopic(questionVo.getTopic());
            question.setCreatedTime(LocalDateTime.now());
            question.setUpdatedTime(LocalDateTime.now());
            question.setQuestion(questionVo.getQuestion());
            question.setUser(user);
            questionRepository.save(question);
            return "Question saved successfully";
        }
        return "Permission Denied";
    }

    @Override
    public String updateQuestionById(Long id, QuestionVo questionVo) {
        User user = userRepository.findById(questionVo.getUser_id()).orElseThrow(() ->
                new UserNotFound("User not found for this id"));
        if(user.getUser_type().equalsIgnoreCase("Questioner")){
        Question question = getQuestionById(id);
        question.setAnswers(questionVo.getAnswers());
        question.setTopic(questionVo.getTopic());
        question.setUpdatedTime(LocalDateTime.now());
        question.setQuestion(questionVo.getQuestion());
        question.setUser(user);
        questionRepository.save(question);
        return "Question with id "+ id + " was updated successfully";
        }
        return "Permission Denied";
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElseThrow(() -> new UserNotFound("Invalid id. No question found with id: " + id));
    }

    @Override
    public String deleteQuestionById(Long id, Long user_id) {
        User user = userRepository.findById(user_id).orElseThrow(()->
                new UserNotFound("User not found for this id"));
        if(user.getUser_type().equalsIgnoreCase("Questioner")) {
            questionRepository.deleteById(id);
            return "Question with id '" + id + "' was deleted successfully";
        }
        return "Permission Denied";
    }

    @Override
    public Page<String> getAllQuestionsWithoutAnswer(Pageable pageable){
        return questionRepository.getAllQuestionsWithoutAnswer(pageable);
    }
}
