package com.macro.mall.tiny.config;

import com.macro.mall.tiny.modules.ums.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * mall-security模块相关配置
 * 自定义配置，只保留登录认证，移除动态RBAC权限加载逻辑
 * Created by macro on 2019/11/9.
 */
@Configuration
public class MallSecurityConfig {

    @Autowired
    private UmsAdminService adminService;

    @Bean
    public UserDetailsService userDetailsService() {
        //获取登录用户信息，只查询ums_admin表，用于账号密码校验
        return username -> adminService.loadUserByUsername(username);
    }

    // ==========重点：删掉了dynamicSecurityService()，不再查询ums_resource表，关闭动态RBAC权限==========
}
