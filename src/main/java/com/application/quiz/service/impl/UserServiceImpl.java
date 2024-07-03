package com.application.quiz.service.impl;

import com.application.quiz.entities.User;
import com.application.quiz.exception.UserNotFound;
import com.application.quiz.repositories.UserRepository;
import com.application.quiz.service.UserService;
import com.application.quiz.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(UserVo userVo) {
        User user = new User();
        user.setId(userVo.getId());
        user.setUser_type(userVo.getUser_type());
        userRepository.save(user);
        return user;
    }

    @Override
    public User updateUser(Long id, UserVo userVo) {
        User user = this.getById(id);
        user.setUser_type(userVo.getUser_type());
        userRepository.save(user);
        return user;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFound("No user found for this id: " + id));
    }

    @Override
    public String deleteUser(Long id) {
        User user = this.getById(id);
        if(user != null){
            userRepository.deleteById(id);
            return "User deleted successfully";
        }
        return "User with this id does not exist: " + id;
    }
}
