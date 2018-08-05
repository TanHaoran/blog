package com.jerry.blog.repository.es;

import com.jerry.blog.domain.es.EsBlog;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class EsBlogRepositoryTest {

    @Autowired
    private EsBlogRepository esBlogRepository;

    @Before
    public void initRepositoryData() {
        // 清除所有数据
        esBlogRepository.deleteAll();

        esBlogRepository.save(new EsBlog("登鹳雀楼", "王之涣的登鹳雀楼",
                "白日依山尽，黄河入海流，欲穷千里目，更上一层楼。"));
        esBlogRepository.save(new EsBlog("相思", "王维的相思",
                "红豆生南国，春来发几枝，愿君多采撷，此物最相思。"));
        esBlogRepository.save(new EsBlog("静夜思", "李白的静夜思",
                "床前明夜光，疑是地上霜，举头望明月，低头思故乡。"));
    }

    @Test
    public void findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining() {
        Pageable pageable = new PageRequest(0, 20);
        String title = "思";
        String summary = "相思";
        String content = "相思";
        Page<EsBlog> page = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title,
                summary, content, pageable);
        assertThat(page.getTotalElements()).isEqualTo(2);

        log.info("------start1");
        for (EsBlog blog : page.getContent()) {
            log.info(blog.toString());
        }
        log.info("------end1");

        title = "相思";
        page = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title,
                summary, content, pageable);
        assertThat(page.getTotalElements()).isEqualTo(1);


        log.info("------start2");
        for (EsBlog blog : page.getContent()) {
            log.info(blog.toString());
        }
        log.info("------end2");

    }
}