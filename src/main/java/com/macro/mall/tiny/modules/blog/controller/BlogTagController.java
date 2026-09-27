package com.macro.mall.tiny.modules.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.modules.blog.model.BlogTag;
import com.macro.mall.tiny.modules.blog.service.BlogTagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog/tag")
@Api(tags = "BlogTagController", description = "博客标签管理")
public class BlogTagController {

    @Autowired
    private BlogTagService blogTagService;

    @ApiOperation("新增标签")
    @PostMapping("/create")
    public CommonResult create(@RequestBody BlogTag blogTag) {
        boolean save = blogTagService.save(blogTag);
        if(save){
            return CommonResult.success("新增成功");
        }
        return CommonResult.failed("新增失败");
    }

    @ApiOperation("删除标签")
    @PostMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Long id) {
        boolean remove = blogTagService.removeById(id);
        if(remove){
            return CommonResult.success("删除成功");
        }
        return CommonResult.failed("删除失败");
    }

    @ApiOperation("修改标签")
    @PostMapping("/update")
    public CommonResult update(@RequestBody BlogTag blogTag) {
        boolean update = blogTagService.updateById(blogTag);
        if(update){
            return CommonResult.success("修改成功");
        }
        return CommonResult.failed("修改失败");
    }

    @ApiOperation("根据id查询标签")
    @GetMapping("/{id}")
    public CommonResult<BlogTag> getOne(@PathVariable Long id) {
        BlogTag tag = blogTagService.getById(id);
        return CommonResult.success(tag);
    }

    @ApiOperation("分页查询标签列表")
    @GetMapping("/list")
    public CommonResult<CommonPage<BlogTag>> list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        Page<BlogTag> page = new Page<>(pageNum, pageSize);
        Page<BlogTag> resultPage = blogTagService.page(page, new LambdaQueryWrapper<BlogTag>());
        return CommonResult.success(CommonPage.restPage(resultPage));
    }

    @ApiOperation("获取全部标签（不分页，前端下拉框用）")
    @GetMapping("/getAllTag")
    public CommonResult<List<BlogTag>> getAllTag() {
        List<BlogTag> list = blogTagService.list();
        return CommonResult.success(list);
    }

}
