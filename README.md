# 个人博客后台系统
基于 mall-tiny 脚手架改造，SpringBoot + MyBatis-Plus 实现的简易博客后台管理项目。

## 技术栈
- 后端：SpringBoot、MyBatis-Plus、MySQL、JWT、Swagger
- 前端：Bootstrap + 原生HTML/JS
- 构建工具：Maven

## 功能模块
1. 管理员登录、登出（JWT令牌认证）
2. 文章管理：新增、编辑、删除、分页查询、上传封面
3. 分类管理：博客文章分类CRUD
4. 标签管理：标签CRUD，文章与标签多对多关联

## 环境要求
- JDK 8
- MySQL 5.7
- Maven 3.6+

## 部署运行
1. 执行sql/mall_tiny.sql，导入数据库表结构
2. 修改application-dev.yml，配置本地MySQL账号密码
3. 启动 MallTinyApplication.java或者终端执行 `mvn spring-boot:run` 启动项目
4. 访问 Swagger文档：http://localhost:8080/swagger-ui/index.html
5. 访问博客后台前端页面：http://localhost:8080/index.html

## 项目亮点
- 使用JWT实现登录鉴权
- MyBatis-Plus实现分页、CRUD
- 文章与标签多对多关联设计
- 简单前端页面，实现博客后台基础维护功能
