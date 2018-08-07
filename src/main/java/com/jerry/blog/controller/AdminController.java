package com.jerry.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 * User: Jerry
 * Date: 2018/8/7
 * Time: 13:48
 * Description: 后台管理Controller
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public ModelAndView listUser(Model model) {
        return new ModelAndView("admin/index", "menuList", model);
    }
}
