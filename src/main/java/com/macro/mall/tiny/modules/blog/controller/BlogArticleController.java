package com.macro.mall.tiny.modules.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.modules.blog.model.BlogArticle;
import com.macro.mall.tiny.modules.blog.service.BlogArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog/article")
@Api(tags = "BlogArticleController", description = "博客文章管理")
public class BlogArticleController {

    @Autowired
    private BlogArticleService blogArticleService;

    @ApiOperation("新增文章")
    @PostMapping("/create")
    public CommonResult create(@RequestBody BlogArticle blogArticle) {
        boolean save = blogArticleService.save(blogArticle);
        if(save){
            // ✅ 新增成功后，保存标签关联
            blogArticleService.saveArticleTag(blogArticle.getId(), blogArticle.getTagIds());
            return CommonResult.success("新增成功");
        }
        return CommonResult.failed("新增失败");
    }

    @ApiOperation("删除文章")
    @PostMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Long id) {
        boolean remove = blogArticleService.removeById(id);
        if(remove){
            return CommonResult.success("删除成功");
        }
        return CommonResult.failed("删除失败");
    }

    @ApiOperation("修改文章")
    @PostMapping("/update")
    public CommonResult update(@RequestBody BlogArticle blogArticle) {
        boolean update = blogArticleService.updateById(blogArticle);
        if(update){
            // ✅ 修改成功后，更新标签关联！这里之前漏掉了！！
            blogArticleService.saveArticleTag(blogArticle.getId(), blogArticle.getTagIds());
            return CommonResult.success("修改成功");
        }
        return CommonResult.failed("修改失败");
    }

    @ApiOperation("根据id查询文章")
    @GetMapping("/{id}")
    public CommonResult<BlogArticle> getOne(@PathVariable Long id) {
        BlogArticle article = blogArticleService.getById(id);
        return CommonResult.success(article);
    }

    @ApiOperation("分页查询文章列表")
    @GetMapping("/list")
    public CommonResult<CommonPage<BlogArticle>> list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        Page<BlogArticle> page = new Page<>(pageNum, pageSize);
        Page<BlogArticle> resultPage = blogArticleService.page(page, new LambdaQueryWrapper<BlogArticle>());
        // ✅ 循环填充每篇文章的标签，前端列表才能显示标签
        for(BlogArticle article : resultPage.getRecords()){
            article.setTagList(blogArticleService.getTagListByArticleId(article.getId()));
        }
        return CommonResult.success(CommonPage.restPage(resultPage));
    }
}
