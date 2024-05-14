package com.test.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        Object loginUser = request.getSession().getAttribute("aduName");

        if (uri.startsWith("/admin") && null == loginUser) {
            response.sendRedirect("/admin/login.html");
            return false;
        }
        return true;
    }
}
