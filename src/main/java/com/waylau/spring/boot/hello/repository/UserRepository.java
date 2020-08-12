package com.waylau.spring.boot.hello.repository;

import com.waylau.spring.boot.hello.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User Repository 接口
 * @author Wagic
 * @date : 2020/8/11 22:40
 **/
@Repository
public interface UserRepository  extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
}
