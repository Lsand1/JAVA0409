package com.test.config;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/admin/login.html").setViewName("login");
        registry.addViewController("/admin").setViewName("login");
    }

    @Resource
    MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor)
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/goLogin")
                .excludePathPatterns("/admin/doLogin")
                .excludePathPatterns("/admin/logout")
                .excludePathPatterns("/admin/login.html")
                ;
    }
}
