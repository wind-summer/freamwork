项目说明

framework快速开发平台的Spring Boot 快速开发平台，包括组织机构管理，用户管理，角色管理，权限管理，文件上传服务， 定时任务管理，SQL监控等等基础功能 
具有如下特点

友好的代码结构及注释，便于阅读及二次开发
实现前后端分离，通过token进行数据交互，前端再也不用关注后端技术
灵活的权限控制，可控制到页面或按钮，满足绝大部分的权限需求
页面交互使用Vue2.x，极大的提高了开发效率
完善的代码生成机制，可在线生成entity、xml、dao、service、html、js、sql代码，减少70%以上的开发任务
引入quartz定时任务，可动态完成任务的添加、修改、删除、暂停、恢复及日志查看等功能
引入API模板，根据token作为登录令牌，极大的方便了APP接口开发
引入Hibernate Validator校验框架，轻松实现后端校验
引入云存储服务，已支持：七牛云、阿里云、腾讯云等
引入swagger文档支持，方便编写API接口文档
引入路由机制，刷新页面会停留在当前页 
数据权限设计思想

管理员管理、角色管理、部门管理，可操作本部门及子部门数据
菜单管理、定时任务、参数管理、系统日志，没有数据权限
业务功能，按照用户数据权限，查询、操作数据【没有本部门数据权限，也能查询本人数据】 
环境要求

JDK1.8+
Maven3.3+
MySql5.7+
Redis2.8+
Git
项目结构

suyun-framework

│
├─common 公共模块
│ 
├─core 业务实现
│ 
├─admin 运营后台
│ 
├─api 前端API 
│  



技术选型：

核心框架：Spring Boot 1.5.8
安全框架：Apache Shiro 1.3
视图框架：Spring MVC 4.3
持久层框架：MyBatis 3.3 + Mybatis-Plus
定时器：Quartz 2.3
数据库连接池：Druid 1.0
日志管理：Logback 
本地部署

通过git下载源码
创建数据库suyun，数据库编码为UTF-8
执行sql/db.sql文件，初始化数据
修改application-dev.yml，更新MySQL账号和密码
分别进入suyun-admin和suyun-api
Eclipse、IDEA运行AdminApplication.java或ApiApplication，则可启动项目
后台服务访问路径：http://localhost:8080/admin
账号密码：admin/admin
前台服务访问路径：http://localhost:8081/api
Swagger路径：http://localhost:8080/admin/swagger/index.html