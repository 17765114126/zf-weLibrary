package com.example.springboot.Config.拦截器;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @ClassName WebConfigurer
 * @Author zhaofu
 * @Date 2019/8/5
 * @Version V1.0
 **/

@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    // 这个方法是用来配置静态资源的，比如html，js，css，等等
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    }

    // 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        //表示拦截所有的请求，
//        //registry.addInterceptor(loginInterceptor). addPathPatterns("/**");
//        //表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
//        //registry.addInterceptor(loginInterceptor).excludePathPatterns("/login");
//        registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
//                .excludePathPatterns("/index").excludePathPatterns("/login");
//        //super.addInterceptors(registry);    //较新Spring Boot的版本中这里可以直接去掉，否则会报错

        // 注册拦截器
         LoginInterceptor loginInterceptor = new LoginInterceptor();

         InterceptorRegistration loginRegistry = registry.addInterceptor(loginInterceptor);
         // 拦截路径
         loginRegistry.addPathPatterns("/**");
         // 排除路径
         loginRegistry.excludePathPatterns("/login");


    }

    /**
     * 跨域支持
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .maxAge(3600 * 24);
    }
}
