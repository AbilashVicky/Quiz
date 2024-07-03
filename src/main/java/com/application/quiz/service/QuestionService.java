package com.application.quiz.service;

import com.application.quiz.entities.Question;
import com.application.quiz.vo.QuestionVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuestionService {
    String addQuestion(QuestionVo questionVo);
    String updateQuestionById(Long id, QuestionVo questionVo);
    List<Question> getAllQuestions();
    Question getQuestionById(Long id);
    String deleteQuestionById(Long id, Long user_id);
    Page<String> getAllQuestionsWithoutAnswer(Pageable pageable);
}
