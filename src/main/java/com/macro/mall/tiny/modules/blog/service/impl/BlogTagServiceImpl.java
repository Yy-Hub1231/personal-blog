package com.macro.mall.tiny.modules.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.blog.mapper.BlogTagMapper;
import com.macro.mall.tiny.modules.blog.model.BlogTag;
import com.macro.mall.tiny.modules.blog.service.BlogTagService;
import org.springframework.stereotype.Service;

@Service
public class BlogTagServiceImpl extends ServiceImpl<BlogTagMapper, BlogTag> implements BlogTagService {

}
