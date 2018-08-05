package com.jerry.blog.repository.es;

import com.jerry.blog.domain.es.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created with IntelliJ IDEA
 * User: Jerry
 * Date: 2018/8/5
 * Time: 19:42
 * Description: EsBlog接口
 */
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog, String> {
    /**
     * 分页查询博客（去重）
     *
     * @param title
     * @param summary
     * @param content
     * @param pageable
     * @return
     */
    Page<EsBlog> findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(String title,
                                                                                           String summary,
                                                                                           String content,
                                                                                           Pageable pageable);
}
