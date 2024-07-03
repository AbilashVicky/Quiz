package com.application.quiz.controller;

import com.application.quiz.entities.Question;
import com.application.quiz.service.QuestionService;
import com.application.quiz.vo.QuestionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz/question")
public class QuestionController {
    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody QuestionVo questionVo){
        String response = questionService.addQuestion(questionVo);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/updateQuestion")
    public ResponseEntity<String> updateQuestionById(@RequestBody QuestionVo questionVo){
        String response = questionService.updateQuestionById(questionVo.getId(), questionVo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getAllQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        List<Question> questions = questionService.getAllQuestions();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @GetMapping("/getQuestionById")
    public ResponseEntity<Question> getQuestionById(@RequestParam Long id){
        Question question = questionService.getQuestionById(id);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

    @GetMapping("/getAllQuestionsWithoutAnswer")
    public ResponseEntity<Page<String>> getAllQuestionsWithoutAnswer(@RequestParam int page, @RequestParam int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        Page<String> questions = questionService.getAllQuestionsWithoutAnswer(pageable);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @DeleteMapping("/deleteQuestionById")
    public ResponseEntity<String> deleteQuestionById(@RequestParam Long id, @RequestParam Long user_id){
        String response = questionService.deleteQuestionById(id, user_id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
