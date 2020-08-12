package com.vvblog.blog.service;

import com.vvblog.blog.domain.User;

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
