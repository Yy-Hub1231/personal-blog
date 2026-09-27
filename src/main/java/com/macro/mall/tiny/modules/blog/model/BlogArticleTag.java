package com.macro.mall.tiny.modules.blog.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("blog_article_tag")
@ApiModel(value="BlogArticleTag对象", description="文章标签中间关联表")
public class BlogArticleTag implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("文章id")
    private Long articleId;

    @ApiModelProperty("标签id")
    private Long tagId;
}
