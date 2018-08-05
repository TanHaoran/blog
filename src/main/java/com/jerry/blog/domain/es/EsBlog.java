package com.jerry.blog.domain.es;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA
 * User: Jerry
 * Date: 2018/8/5
 * Time: 19:24
 * Description: Es全文搜索实体类
 */
@Data
@ToString
@Document(indexName = "blog", type = "blog") // 标明是文档类
public class EsBlog implements Serializable {

    @Id
    private String id;
    private String title;
    private String summary;
    private String content;

    protected EsBlog() {

    }

    public EsBlog(String title, String summary, String content) {
        this.title = title;
        this.summary = summary;
        this.content = content;
    }
}
