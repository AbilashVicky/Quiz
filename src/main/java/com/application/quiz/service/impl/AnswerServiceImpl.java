package com.application.quiz.service.impl;

import com.application.quiz.entities.Answer;
import com.application.quiz.entities.Question;
import com.application.quiz.entities.User;
import com.application.quiz.exception.UserNotFound;
import com.application.quiz.repositories.AnswerRepository;
import com.application.quiz.repositories.QuestionRepository;
import com.application.quiz.repositories.UserRepository;
import com.application.quiz.service.AnswerService;
import com.application.quiz.vo.AnswerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;

    @Autowired
    public AnswerServiceImpl(AnswerRepository answerRepository, UserRepository userRepository, QuestionRepository questionRepository){
        this.answerRepository = answerRepository;
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public String addAnswer(AnswerVo answerVo) {
        User user = userRepository.findById(answerVo.getUser_id()).orElseThrow(() ->
                new UserNotFound("User not found with this id"));
        Question question = questionRepository.findById(answerVo.getQuestion_id()).orElseThrow(()->
                new UserNotFound("No question found matching this id"));
        if(user.getUser_type().equalsIgnoreCase("Respondent")){
            Answer answer = new Answer();
            answer.setId(answerVo.getId());
            answer.setAnswer(answerVo.getAnswer());
            answer.setCreatedTime(LocalDateTime.now());
            answer.setUpdatedTime(LocalDateTime.now());
            answer.setTopic(answerVo.getTopic());
            answer.setQuestion(question);
            answer.setUser(user);
            answerRepository.save(answer);
            return "Answer saved successfully";
        }
        return "Answer not saved. User access denied";
    }

    @Override
    public String updateAnswerById(Long id, AnswerVo answerVo) {
        User user = userRepository.findById(answerVo.getUser_id()).orElseThrow(() ->
                new UserNotFound("User not found with this id"));
        Question question = questionRepository.findById(answerVo.getQuestion_id()).orElseThrow(()->
                new UserNotFound("No question found matching this id"));
        if(user.getUser_type().equalsIgnoreCase("Respondent")){
            Answer answer = getAnswerById(id);
            answer.setTopic(answerVo.getTopic());
            answer.setUpdatedTime(LocalDateTime.now());
            answer.setQuestion(question);
            answer.setAnswer(answerVo.getAnswer());
            answer.setUser(user);
            answerRepository.save(answer);
            return "Answer updated successfully";
        }
        return "Answer not updated. User access denied";
    }

    @Override
    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }

    @Override
    public Answer getAnswerById(Long id) {
        return answerRepository.findById(id).orElseThrow(() -> new UserNotFound("Invalid id. Answer not found with id: " + id));
    }

    @Override
    public String deleteAnswerById(Long id, Long user_id) {
        User user = userRepository.findById(user_id).orElseThrow(() -> new UserNotFound("User not found with this id"));
        if(user.getUser_type().equalsIgnoreCase("Respondent")){
            answerRepository.deleteById(id);
            return "Answer with id '" + id + "' was deleted successfully";
        }
        return "Answer not deleted. User access denied";
    }
}
