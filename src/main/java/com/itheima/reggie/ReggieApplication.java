package com.itheima.reggie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j /*日志框架。可以省略get、set方法，可以直接使用log方法*/
@SpringBootApplication /*声明springboot启动类*/
@ServletComponentScan /*扫描web、filter的注解*/
@EnableTransactionManagement /*开启事务注解的支持*/
public class ReggieApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReggieApplication.class,args);
        log.info("项目启动成功");
    }
}
