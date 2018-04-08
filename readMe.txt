# 此工程依赖framework-*.jar。这个在另一个工程里面
# 运行生产环境时去掉 @EnableSwagger2 这个可以用来查看接口。
# 后续增加sql数据库查询监控
# 增加应用监控 @EnableAdminServer。
--启用监控要启动工程hsm-metrics
--添加jar包依赖
    <dependency>
        <groupId>de.codecentric</groupId>
        <artifactId>spring-boot-admin-starter-client</artifactId>
        <version>1.5.6</version>
    </dependency>
    spring.boot.admin.url=http://localhost:8181
# 生产环境打包用sit.properties，这样不会有debug信息输出
# 开发的时候，根据条件查询，请用redis缓存减少数据库请求,spring redis缓存主要用来做数据变化不大的业务。
--
# 数据实时变化的业务，使用databus进行更新到redis。直接查询即可。取不到的话，再从数据库里面去取。