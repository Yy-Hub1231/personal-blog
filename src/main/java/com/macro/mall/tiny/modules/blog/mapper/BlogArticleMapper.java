package com.macro.mall.tiny.modules.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.macro.mall.tiny.modules.blog.model.BlogArticle;
import com.macro.mall.tiny.modules.blog.model.BlogTag;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BlogArticleMapper extends BaseMapper<BlogArticle> {

    // 查询文章对应的标签
    @Select("SELECT t.* FROM blog_tag t INNER JOIN blog_article_tag rel ON t.id = rel.tag_id WHERE rel.article_id = #{articleId}")
    List<BlogTag> selectTagListByArticleId(@Param("articleId") Long articleId);

    // 删除文章全部旧标签关联（操作中间表）
    @Delete("DELETE FROM blog_article_tag WHERE article_id = #{articleId}")
    void deleteArticleTagRel(@Param("articleId") Long articleId);

    // 新增一条文章标签关联（操作中间表）
    @Insert("INSERT INTO blog_article_tag(article_id, tag_id) VALUES(#{articleId},#{tagId})")
    void insertArticleTagRel(@Param("articleId") Long articleId, @Param("tagId") Long tagId);
}
