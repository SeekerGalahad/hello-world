package com.vvblog.blog.repository.es;

import com.vvblog.blog.domain.es.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * EsBlog Repository 接口
 * @author wagic
 */
@Repository
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog, String> {
    /**
     * 分页查询博客（去重）
     * 全文检索标题 或 摘要 或 正文 是否包含关键字
     * @param title
     * @param summary
     * @param content
     * @return
     */
    Page<EsBlog> findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(String title, String summary, String content, Pageable pageable);
}
