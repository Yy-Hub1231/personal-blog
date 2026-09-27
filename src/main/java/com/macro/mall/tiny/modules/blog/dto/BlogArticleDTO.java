package com.macro.mall.tiny.modules.blog.dto;

import com.macro.mall.tiny.modules.blog.model.BlogArticle;
import java.util.List;

public class BlogArticleDTO extends BlogArticle {
    // 前端传过来选中的标签id数组
    private List<Long> tagIds;

    public List<Long> getTagIds() {
        return tagIds;
    }

    public void setTagIds(List<Long> tagIds) {
        this.tagIds = tagIds;
    }
}
