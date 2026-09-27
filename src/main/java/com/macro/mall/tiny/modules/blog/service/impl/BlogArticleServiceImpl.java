package com.macro.mall.tiny.modules.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.blog.mapper.BlogArticleMapper;
import com.macro.mall.tiny.modules.blog.model.BlogArticle;
import com.macro.mall.tiny.modules.blog.model.BlogTag;
import com.macro.mall.tiny.modules.blog.service.BlogArticleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import javax.annotation.Resource;
import java.util.List;

@Service
public class BlogArticleServiceImpl extends ServiceImpl<BlogArticleMapper, BlogArticle> implements BlogArticleService {

    @Resource
    private BlogArticleMapper blogArticleMapper;

    @Override
    public List<BlogTag> getTagListByArticleId(Long articleId) {
        return blogArticleMapper.selectTagListByArticleId(articleId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveArticleTag(Long articleId, List<Long> tagIds) {
        // 删除当前文章所有旧标签关联
        blogArticleMapper.deleteArticleTagRel(articleId);

        // 标签为空直接返回
        if (CollectionUtils.isEmpty(tagIds)) {
            return;
        }

        // 循环插入新的标签关联
        for (Long tagId : tagIds) {
            blogArticleMapper.insertArticleTagRel(articleId, tagId);
        }
    }
}
