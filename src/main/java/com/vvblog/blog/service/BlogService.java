package com.vvblog.blog.service;

import com.vvblog.blog.domain.es.EsBlog;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author w3760
 */
public interface BlogService {
    List<EsBlog> getBlogs(String title, String summary, String content,
                          int pageIndex, int pageSize);
}
