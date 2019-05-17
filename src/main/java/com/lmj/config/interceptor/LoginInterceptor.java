package com.lmj.config.interceptor;

import com.lmj.model.User;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    //执行方法前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object o) throws Exception {
        User user =(User) request.getSession().getAttribute("user");
        if(user == null){
            response.sendRedirect(request.getContextPath()+"/user/login");

            return false;
        }
        return true;
    }

    //执行方法后，返回值之前
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }
    //执行方法返回值之后
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
