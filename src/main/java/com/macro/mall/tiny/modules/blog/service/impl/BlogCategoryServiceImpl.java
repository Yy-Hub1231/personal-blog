package com.macro.mall.tiny.modules.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.blog.mapper.BlogCategoryMapper;
import com.macro.mall.tiny.modules.blog.model.BlogCategory;
import com.macro.mall.tiny.modules.blog.service.BlogCategoryService;
import org.springframework.stereotype.Service;

@Service
public class BlogCategoryServiceImpl extends ServiceImpl<BlogCategoryMapper, BlogCategory> implements BlogCategoryService {

}
