package com.example.springboot.Config.IocOrDI;

import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName AppConfig
 * @Author zhaofu
 * @Date 2019/10/26
 * @Version V1.0
 * @Description: 定义装配文件--
 * 注解@ComponentScan
 * basePackages 用来扫描相对应的包
 *
 * excludeFilters = {@Filter({IocTest.class})}
 **/
@ComponentScan(basePackages = "com.example.springboot.model")
public class AppConfig {}
