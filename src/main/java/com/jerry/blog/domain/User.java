package com.jerry.blog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * User: Jerry
 * Date: 2018/7/14
 * Time: 10:20
 * Description: 用户实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /**
     * 唯一标示
     */
    private Long id;

    private String name;

    private String email;

}
