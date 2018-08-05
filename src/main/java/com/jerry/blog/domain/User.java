package com.jerry.blog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: Jerry
 * Date: 2018/7/14
 * Time: 10:20
 * Description: 用户实体
 */
@Data
@AllArgsConstructor
@Entity
@ToString
public class User {

    /**
     * 唯一标示
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增策略
    private Long id;

    private String name;

    private String email;

    protected User() {

    }

}
