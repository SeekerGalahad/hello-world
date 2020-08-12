package com.waylau.spring.boot.hello.repository;

import com.waylau.spring.boot.hello.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author Wagic
 * @date : 2020/8/11 23:41
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testJpaRepository() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }
}
