package com.jerry.blog.controller;

import com.jerry.blog.domain.es.EsBlog;
import com.jerry.blog.repository.es.EsBlogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * User: Jerry
 * Date: 2018/8/5
 * Time: 23:37
 * Description: Blog的Controller
 */
@Controller
@RequestMapping("/blog")
@Slf4j
public class BlogController {

    @GetMapping
    public String listBlog(@RequestParam(value = "order", required = false, defaultValue = "new") String order,
                           @RequestParam(value = "keyword", required = false, defaultValue = "") Long keyword) {
        log.info("order:{}, keyword:{}", order, keyword);
        return "redirect:/index?order=" + order + "&keyword=" + keyword;
    }
}
