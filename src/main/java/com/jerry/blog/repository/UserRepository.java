package com.jerry.blog.repository;

import com.jerry.blog.domain.User;
import org.springframework.data.repository.CrudRepository;


/**
 * Created with IntelliJ IDEA.
 * User: Jerry
 * Date: 2018/7/14
 * Time: 10:31
 * Description: 用户Repository接口
 */
public interface UserRepository extends CrudRepository<User, Long> {

}
