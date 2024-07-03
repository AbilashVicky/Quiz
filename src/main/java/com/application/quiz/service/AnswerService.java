package com.application.quiz.service;

import com.application.quiz.entities.Answer;
import com.application.quiz.vo.AnswerVo;

import java.util.List;

public interface AnswerService {
    String addAnswer(AnswerVo answerVo);
    String updateAnswerById(Long id, AnswerVo answerVo);
    List<Answer> getAllAnswers();
    Answer getAnswerById(Long id);
    String deleteAnswerById(Long id, Long user_id);
}
