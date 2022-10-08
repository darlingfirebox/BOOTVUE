package com.example.bootvue.config;

import com.example.bootvue.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 加载各类配置文件
// 注册拦截器，注册以后才会生效
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 配置拦截路径
        // addPathPatterns 方法设置拦截路径，不写则默认拦截所有请求
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/user/**");
    }
}
