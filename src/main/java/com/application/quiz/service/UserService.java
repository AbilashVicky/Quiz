package com.application.quiz.service;

import com.application.quiz.entities.User;
import com.application.quiz.vo.UserVo;

import java.util.List;

public interface UserService {
    User addUser(UserVo userVo);
    User updateUser(Long id, UserVo userVo);
    List<User> getAll();
    User getById(Long id);
    String deleteUser(Long id);
}
