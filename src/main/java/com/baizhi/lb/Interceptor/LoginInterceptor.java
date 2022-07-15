package com.baizhi.lb.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    public String[] allowUrls;
    public void setAllowUrls( String []allowUrls) {
        this.allowUrls = allowUrls;
    }


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //对静态资源放行
        String requestUrl = request.getRequestURI().replace(request.getContextPath(), "");
        if(null != allowUrls && allowUrls.length>=1) {
            for (String url : allowUrls) {
                if (requestUrl.contains(url)) {
                    return true;
                }
            }
        }
        if (request.getSession().getAttribute("user")==null){
            response.sendRedirect("/telbook");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}