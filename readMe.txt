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
--spring boot admin 监控要打成jar，war尝试过不行，也就是直接run Application
# 生产环境打包用sit.properties，这样不会有debug信息输出
# 开发的时候，根据条件查询，请用redis缓存减少数据库请求,spring redis缓存主要用来做数据变化不大的业务。
--
# 缓存使用。 一下2种都可以。
--redis缓存， 用于定时更新的数据。
--guava缓存， 用于实时更新的数据,请求又非常频繁的时候。原因：能够主动去调用，并且多个线程取同一份数据的时候，不会调用api多次。只会一个区调用，其他等待。
# 开启spring boot admin 可视化监控。
--只能用Application启动，不能用war启动，否则发现不了client
--将//@ComponentScan({"com.hsm","com.framework"}) 提取到外面 Application
--一定要将Application 放到最上层目录下， 否则扫描不到
--将以下exclusions部分去掉，使用内部tomcat
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <!--<exclusions>-->
                <!--<exclusion>-->
                    <!--<groupId>org.springframework.boot</groupId>-->
                    <!--<artifactId>spring-boot-starter-tomcat</artifactId>-->
                <!--</exclusion>-->
            <!--</exclusions>-->
        </dependency>