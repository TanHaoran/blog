package com.jerry.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created with IntelliJ IDEA.
 * User: Jerry
 * Date: 2018/8/7
 * Time: 16:28
 * Description:
 */
@Controller
public class MaiController {
    @GetMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        model.addAttribute("errorMsg", "登录失败，用户名或密码错误");
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }
}
