package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 無條件允許
        System.out.println("執行 MyInterceptor 的 preHandle()");
        return true;
//        // 設定「身份未驗證」的狀態碼，並回傳 false，使攔截器不允許該 http request 通過。
//        response.setStatus(401);
//        return false;
    }
}
