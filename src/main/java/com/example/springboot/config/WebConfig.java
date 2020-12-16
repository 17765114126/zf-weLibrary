package com.example.springboot.config;

import com.example.springboot.config.annotation.EncryptFormatterFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Description 配置类
 * @Author zf
 * @Date 2020/4/28 13:40
 * @Version 1.0
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addFormatters(FormatterRegistry registry) {
        EncryptFormatterFactory stringEncryptAnnotionFormatterFactory = new EncryptFormatterFactory();
        registry.addFormatterForFieldAnnotation(stringEncryptAnnotionFormatterFactory);
        super.addFormatters(registry);

    }
}
