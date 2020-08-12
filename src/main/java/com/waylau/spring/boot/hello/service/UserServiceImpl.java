package com.waylau.spring.boot.hello.service;

import com.waylau.spring.boot.hello.domain.User;
import com.waylau.spring.boot.hello.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wagic
 * @date : 2020/8/11 23:57
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getByUserId(Long userId) {
        return userRepository.findOne(userId);
    }

    @Override
    public User saveOrUpdateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.delete(userId);
    }
}
