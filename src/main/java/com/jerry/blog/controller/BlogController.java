package com.jerry.blog.controller;

import com.jerry.blog.domain.es.EsBlog;
import com.jerry.blog.repository.es.EsBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private EsBlogRepository esBlogRepository;

    @GetMapping
    public List<EsBlog> list(@RequestParam String title,
                             @RequestParam String summary,
                             @RequestParam String content,
                             @RequestParam(value = "page", defaultValue = "0") int page,
                             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Pageable pageable = new PageRequest(page, pageSize);
        Page<EsBlog> blogPage = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title,
                summary, content, pageable);
        return blogPage.getContent();
    }
}
