package com.vvblog.blog.repository;

import com.vvblog.blog.domain.es.EsBlog;
import com.vvblog.blog.repository.es.EsBlogRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Wagic
 * @date : 2020/8/11 23:41
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsBlogRepositoryTest {

    @Autowired
    private EsBlogRepository blogRepository;

    @Test
    public void testFindByTitleLikeOrContentLike() {
        // 清空所有
        blogRepository.deleteAll();

        blogRepository.save(EsBlog.builder().id("1").title("安装").summary("老卫跟你谈谈安装 Elasticsearch")
                .content("关于如何来安装 Elasticsearch，这个请看我的博客 https://waylau.com").build());
        blogRepository.save(EsBlog.builder().id("2").title("使用").summary("老卫跟你谈谈 Elasticsearch 的几个用法")
                .content("关于如何来用 Elasticsearch，还是得看我的博客 https://waylau.com").build());
        blogRepository.save(EsBlog.builder().id("3").title("学习").summary("老卫和你一起学 Elasticsearch")
                .content("Elasticsearch，最终看我的博客 https://waylau.com").build());
        blogRepository.save(EsBlog.builder().id("4").title("分布式系统").summary("03-05 用大白话聊聊分布式系统")
                .content("一提起“分布式系统”，大家的第一感觉就是好高大上啊，深不可测").build());
        blogRepository.save(EsBlog.builder().id("5").title("Thymeleaf").summary("02-19 Thymeleaf 3 引入了新的解析系统")
                .content("如果你的代码使用了 HTML5 的标准，而Thymeleaf 版本来停留在 2.x ，那么如果没有把闭合").build());
        blogRepository.save(EsBlog.builder().id("6").title("插件").summary("02-19 使用 GFM Eclipse 插件时，不在项目里面生成 HTML 文件")
                .content("GFM 是 GitHub Flavored Markdown Viewer 的简称，是一款对 GitHub 友好的 Markdown 编辑器 。").build());

        Pageable pageable = new PageRequest(0, 20);
        String title = "";
        String summary = "";
        String content = "Elasticsearch";
        Page<EsBlog> page = blogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title, summary, content, pageable);
        assertThat(page.getTotalElements()).isEqualTo(1);
    }
}
