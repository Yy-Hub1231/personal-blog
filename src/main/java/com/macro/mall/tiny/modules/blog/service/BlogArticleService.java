package com.macro.mall.tiny.modules.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.macro.mall.tiny.modules.blog.model.BlogArticle;
import com.macro.mall.tiny.modules.blog.model.BlogTag;

import java.util.List;

public interface BlogArticleService extends IService<BlogArticle> {
    // 根据文章id查询标签列表
    List<BlogTag> getTagListByArticleId(Long articleId);

    // 保存文章标签关联
    void saveArticleTag(Long articleId, List<Long> tagIds);
}
