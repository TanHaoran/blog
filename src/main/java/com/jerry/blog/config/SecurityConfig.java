package com.jerry.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created with IntelliJ IDEA
 * User: Jerry
 * Date: 2018/8/6
 * Time: 21:11
 * Description: 安全配置类
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // 认证信息存储在内存中
        auth.inMemoryAuthentication()
                .withUser("jerry").password("123456").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 可以直接访问
                .antMatchers("/css/**", "/js/**", "/font/**", "/index").permitAll()
                // 需要对应角色才能访问
                .antMatchers("/user/**").hasRole("ADMIN")
                .and()
                // 基于Form表单验证
                .formLogin()
                // 自定义登录页面
                .loginPage("/login").failureUrl("/login-error");
    }


}
