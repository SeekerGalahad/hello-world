package com.vvblog.blog.service;

import com.vvblog.blog.domain.es.EsBlog;
import com.vvblog.blog.repository.es.EsBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Wagic
 * @date : 2020/8/13 23:05
 **/
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private EsBlogRepository blogRepository;

    @Override
    public List<EsBlog> getBlogs(String title, String summary, String content, int pageIndex, int pageSize) {
        Pageable pageable = new PageRequest(pageIndex, pageSize);
        Page<EsBlog> esBlogPage = blogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title, summary, content, pageable);
        return esBlogPage.getContent();
    }
}
