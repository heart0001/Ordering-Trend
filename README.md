仿美团外卖项目，包括系统管理后台和移动端页面。管理员可以在后台对员工、菜品、套餐、订单等进行管理，用户可以在前台查看菜品并添加到购物车下单。 

### 一、技术

前端：原生 HTML + 渐进式 Vue + Axios + Element UI
后端：Spring Boot + SSM + MyBatis Plus + Spring Cache + Redis + Sharding JDBC 读写分离 + 短信 SDK + Lombok
部署：前后端不分离 jar 包部署或者 Nginx 部署前端

### 二、所需环境

- JDK8 本项目由JDK8构建，请在运行本项目前确保您的电脑已安装JDK8，若您使用的是IntelliJ IDEA，您可以很方便的在`Project Structure`中配置JDK版本。
- MySQL 本项目使用MySQL数据库，请在运行本项目前确保您可以顺利连接到MySQL数据库。
- Redis 本项目使用Redis缓存，请在运行本项目前确保您可以顺利连接到Redis数据库
- Maven 本项目使用Maven构建，初次打开项目时，IntelliJ IDEA会自动下载Maven依赖，若您的IntelliJ IDEA没有识别到Maven，请右键项目，选择`Add Framework Support`，选择`Maven`，然后点击`OK`。

### 三、项目要点

1. 基本上把企业开发需要用到的主流基本技术都用到了
2. 目录结构规范，接口设计遵循 Restful 规范
3. 可以通过该项目快速学习 Git、Linux、Redis、Nginx、读写分离、第三方 API 调用等知识
4. 为集中处理系统异常，自定义统一的错误码，并封装了 全局异常处理器 ，屏蔽了项目冗余的报错细节、便于接口调用方理解和统一处理。
5. 基于静态 ThreadLocal 封装了线程隔离的全局上下文对象，便于在请求内部存取用户信息，减少用户远程查询次数。

6. 为兼容请求参数 date 类型的序列化，自定义 Jackson 对象映射器处理日期；并扩展 SpringMVC 的消息转换器，实现自动序列化。

7. 自定义 MyBatis Plus 的 MetaObjectHandler，配合全局上下文实现写数据前的创建时间、用户 id 字段的自动填充。
8. 遵循 Restful 设计规范编写接口，降低前后端接口沟通和理解成本。
9. 为解决原生 Jdk 序列化器导致的缓存 key 值乱码问题，自定义 RedisTemplate Bean 的 Redis Key 序列化器为 StringRedisSerializer。
10. 使用 Knife4j + Swagger 自动生成后端接口文档，并通过编写 ApiOperation 等注解补充接口注释，避免了人工编写维护文档的麻烦。

11. 为省去重复编写用户校验的麻烦，基于 WebFilter 实现全局登录校验；并通过 AntPathMatcher 来匹配动态请求路径，实现灵活的可选鉴权。

12. 为保证数据的完整性和一致性，使用 [@Transactional ](https://bcdh.yuque.com/Transactional) 实现数据库事务，并配置 rollbackFor = Exception.class 来支持受检异常的事务回滚。 

13. 为提高 XX 信息页加载速度，基于 Spring Cache 注解 + Redis 实现对 XX 信息的自动缓存，大幅降低数据库压力的同时将接口响应耗时由 0.8s 减少至 50ms

14. 为降低开发成本，使用 MyBatis Plus 框架自动生成业务的增删改查重复代码，并使用 LambdaQueryWrapper 实现更灵活地自定义查询。
15. 为降低用户注册成本、保证用户真实性，二次封装 XX 云 SDK 接入短信服务，并通过 Redis 来集中缓存验证码，防止单手机号的重复发送。
16. 为提高数据库整体读写性能，配置 MySQL 主从同步，并使用 sharding-jdbc 实现业务无侵入的读写分离。
17. 封装全局 Axios 请求实例，添加全局请求拦截和全局异常响应处理器，减少重复的状态码判断、提升项目可维护性。

### 管理端：

<img src="https://img-blog.csdnimg.cn/845e2371732b4c128a3cad5067c2f3a2.png#pic_center" alt="image-20230905115651482" style="zoom:50%;" />

<img src="https://img-blog.csdnimg.cn/8be3691f8997476195ec2c348b76b6ef.png#pic_center" alt="image-20230905120510577" style="zoom:50%;" />

<img src="https://img-blog.csdnimg.cn/9f97dd1e25cd41e6becbfc481fac6a9f.png#pic_center" alt="image-20230905123533867" style="zoom:50%;" />



<img src="https://img-blog.csdnimg.cn/f4705311a3d74992a7872e2af52f4421.png#pic_center" alt="image-20230905123450219" style="zoom:50%;" />



### 移动端：

<img src="https://img-blog.csdnimg.cn/e717f944834641c989399d5bfc9ff4b3.png#pic_center" alt="image-20230905123343549" style="zoom:50%;" />

<img src="https://img-blog.csdnimg.cn/2371644bc2554a8ea2144b8c4676f739.png#pic_center" alt="image-20230905123255859" style="zoom:50%;" />

