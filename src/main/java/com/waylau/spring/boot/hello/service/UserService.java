package com.waylau.spring.boot.hello.service;

import com.waylau.spring.boot.hello.domain.User;

import java.util.List;

/**
 * @author wagic
 */
public interface UserService {
    List<User> listAllUsers();

    User getByUserId(Long userId);

    User saveOrUpdateUser(User user);

    void deleteUser(Long userId);
}
