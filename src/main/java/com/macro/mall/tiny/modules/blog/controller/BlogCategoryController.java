package com.macro.mall.tiny.modules.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.modules.blog.model.BlogCategory;
import com.macro.mall.tiny.modules.blog.service.BlogCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog/category")
@Api(tags = "BlogCategoryController", description = "博客分类管理")
public class BlogCategoryController {

    @Autowired
    private BlogCategoryService blogCategoryService;

    @ApiOperation("新增分类")
    @PostMapping("/create")
    public CommonResult create(@RequestBody BlogCategory blogCategory) {
        boolean save = blogCategoryService.save(blogCategory);
        if(save){
            return CommonResult.success("新增成功");
        }
        return CommonResult.failed("新增失败");
    }

    @ApiOperation("删除分类")
    @PostMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Long id) {
        boolean remove = blogCategoryService.removeById(id);
        if(remove){
            return CommonResult.success("删除成功");
        }
        return CommonResult.failed("删除失败");
    }

    @ApiOperation("修改分类")
    @PostMapping("/update")
    public CommonResult update(@RequestBody BlogCategory blogCategory) {
        boolean update = blogCategoryService.updateById(blogCategory);
        if(update){
            return CommonResult.success("修改成功");
        }
        return CommonResult.failed("修改失败");
    }

    @ApiOperation("根据id查询分类")
    @GetMapping("/{id}")
    public CommonResult<BlogCategory> getOne(@PathVariable Long id) {
        BlogCategory category = blogCategoryService.getById(id);
        return CommonResult.success(category);
    }

    @ApiOperation("分页查询分类列表")
    @GetMapping("/list")
    public CommonResult<CommonPage<BlogCategory>> list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                       @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        Page<BlogCategory> page = new Page<>(pageNum, pageSize);
        Page<BlogCategory> resultPage = blogCategoryService.page(page, new LambdaQueryWrapper<BlogCategory>());
        return CommonResult.success(CommonPage.restPage(resultPage));
    }
    @ApiOperation("查询全部分类(不分页)")
    @GetMapping("/getAllCategory")
    public CommonResult<List<BlogCategory>> getAllCategory(){
        List<BlogCategory> categoryList = blogCategoryService.list();
        return CommonResult.success(categoryList);
    }
}
