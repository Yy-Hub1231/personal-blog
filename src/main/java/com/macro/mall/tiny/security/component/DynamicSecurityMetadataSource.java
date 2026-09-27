package com.macro.mall.tiny.security.component;

import cn.hutool.core.util.URLUtil;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 动态权限数据源，用于获取动态权限规则
 * Created by macro on 2020/2/7.
 * 【改造：停用动态RBAC权限，全部注释，不再读取数据库权限表】
 */
public class DynamicSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    // 注释掉动态权限加载相关
//    private static Map<String, ConfigAttribute> configAttributeMap = null;
//    @Autowired
//    private DynamicSecurityService dynamicSecurityService;
//
//    @PostConstruct
//    public void loadDataSource() {
//        configAttributeMap = dynamicSecurityService.loadDataSource();
//    }
//
//    public void clearDataSource() {
//        configAttributeMap.clear();
//        configAttributeMap = null;
//    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        // 直接返回空集合，不再加载权限数据
        return new ArrayList<>();
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
