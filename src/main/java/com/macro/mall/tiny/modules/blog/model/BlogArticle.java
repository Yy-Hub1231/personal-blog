package com.macro.mall.tiny.modules.blog.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("blog_article")
@ApiModel(value="BlogArticle对象", description="博客文章表")
public class BlogArticle implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("文章id")
    private Long id;

    @ApiModelProperty("文章标题")
    private String title;

    @ApiModelProperty("文章内容")
    private String content;

    @ApiModelProperty("分类id")
    private Long categoryId;

    @ApiModelProperty("作者")
    private String author;

    @ApiModelProperty("状态：1发布 0草稿")
    private Integer status;

    @ApiModelProperty("文章封面图片地址")
    private String cover;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @TableField(exist = false)
    @ApiModelProperty("前端传进来选中的标签id数组")
    private List<Long> tagIds;

    @TableField(exist = false)
    @ApiModelProperty("返回前端：文章对应的标签列表，用于页面展示")
    private List<BlogTag> tagList;
}
