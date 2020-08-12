package com.waylau.spring.boot.hello.domain;

import lombok.*;

import javax.persistence.*;

/**
 * @author Wagic
 * @date : 2020/8/11 22:33
 **/
@Entity
@Table(name = "user")
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
}
