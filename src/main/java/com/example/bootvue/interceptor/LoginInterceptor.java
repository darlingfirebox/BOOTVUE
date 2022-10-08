package com.example.bootvue.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 拦截器
// preHandle 在目标方法前执行设定的方法
// postHandle 在目标方法后执行设定的方法
// afterCompletion 在页面渲染完成后执行设定的方法
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("LoginInterceptor");
        return true;
    }
}
