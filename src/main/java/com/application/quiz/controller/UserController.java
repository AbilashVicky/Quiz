package com.application.quiz.controller;

import com.application.quiz.entities.User;
import com.application.quiz.service.UserService;
import com.application.quiz.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody UserVo userVo){
        User user = userService.addUser(userVo);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<User> updateUser(@RequestBody UserVo userVo){
        User user = userService.updateUser(userVo.getId(), userVo);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/getUserById")
    public ResponseEntity<User> getById(@RequestParam Long id){
        User user = userService.getById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUserById")
    public ResponseEntity<String> deleteById(@RequestParam Long id){
        String result = userService.deleteUser(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
