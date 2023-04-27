package com.tjut.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tjut.pojo.dto.CommonResult;
import com.tjut.util.jwtUtil.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        String method = request.getMethod();
        String requestURI = request.getRequestURI();
        if(method.equals("POST") && requestURI.equals("/registration-information")) return true;

        if (null == token || "".equals(token) || !JwtUtils.verify(token)) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            ObjectMapper objectMapper = new ObjectMapper();
            if(!(null == token || "".equals(token))){
                response.getWriter().println(objectMapper.writeValueAsString(CommonResult.tokenWrong()));
            }else response.getWriter().println(objectMapper.writeValueAsString(CommonResult.tokenNull()));
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

}
