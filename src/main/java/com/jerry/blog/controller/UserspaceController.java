package com.jerry.blog.controller;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with IntelliJ IDEA.
 * User: Jerry
 * Date: 2018/8/7
 * Time: 13:37
 * Description:
 */
@Controller
@RequestMapping("/u")
@Slf4j
public class UserspaceController {

    @GetMapping("/{username}")
    public String userSpace(@PathVariable String username) {
        log.info("username:{}", username);
        return "/userspace/u";
    }

    @GetMapping("/{username}/blog")
    public String listBlogByOrder(@PathVariable String username,
                                  @RequestParam(value = "order", required = false, defaultValue = "new") String order,
                                  @RequestParam(value = "category", required = false) Long category,
                                  @RequestParam(value = "keyword", required = false) String keyword) {
        if (category != null) {
            log.info("category:{}", category);
            log.info("selfLink:{}", "redirect:/u/" + username + "/blog?category=" + category);
            return "/userspace/u";
        } else if (keyword != null && keyword.isEmpty() == false) {
            log.info("keyword:{}", keyword);
            log.info("selfLink:{}", "redirect:/u/" + username + "/blog?keyword=" + keyword);
            return "/userspace/u";
        }

        log.info("order:{}", order);
        log.info("selfLink:{}", "redirect:/u/" + username + "/blog?order=" + order);
        return "/userspace/u";
    }

    @GetMapping("/{username}/blog/{id}")
    public String listBlogByOrder(@PathVariable Long id) {
        log.info("blogId:{}", id);
        return "/userspace/blog";
    }

    @GetMapping("/{username}/blog/edit")
    public String editBlog() {
        return "/username/blog-edit";
    }
}
