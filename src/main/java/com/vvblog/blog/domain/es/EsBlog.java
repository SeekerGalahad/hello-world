package com.vvblog.blog.domain.es;

import lombok.*;
import lombok.experimental.Tolerate;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * Blog 文档类
 * @author Wagic
 * @date : 2020/8/13 22:13
 **/
@Data
@ToString
@Builder
@Document(indexName = "blog", type = "blog")
public class EsBlog implements Serializable {
    private static final long serialVersionUID = -795969732332119577L;
    @Id
    private String id;
    private String title;
    private String summary;
    private String content;
    @Tolerate
    protected EsBlog() {
    }
}
