package com.application.quiz.controller;

import com.application.quiz.entities.Answer;
import com.application.quiz.service.AnswerService;
import com.application.quiz.vo.AnswerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz/answer")
public class AnswerController {
    private final AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping("/addAnswer")
    public ResponseEntity<String> addAnswer(@RequestBody AnswerVo answerVo){
        String response = answerService.addAnswer(answerVo);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/updateAnswerById")
    public ResponseEntity<String> updateAnswer(@RequestBody AnswerVo answerVo){
        String response = answerService.updateAnswerById(answerVo.getId(), answerVo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getAllAnswers")
    public ResponseEntity<List<Answer>> getAllAnswers(){
        List<Answer> response = answerService.getAllAnswers();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getAnswerById/{id}")
    public ResponseEntity<Answer> getAnswerByID(@PathVariable Long id){
        Answer answer = answerService.getAnswerById(id);
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAnswerById")
    public ResponseEntity<String> deleteAnswerById(@RequestParam Long id, @RequestParam Long user_id){
        String response = answerService.deleteAnswerById(id, user_id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
