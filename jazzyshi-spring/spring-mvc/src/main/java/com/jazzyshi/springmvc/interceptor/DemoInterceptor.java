package com.jazzyshi.springmvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器：跟过滤器比较像的技术
 * 发送请求时被拦截器拦截，在控制器的前后添加额外的功能
 * 1.AOP在特定方法前后扩充（对SevciceImpl）
 * 2.拦截器针对的是控制器方法（对Controller）
 * 3.Filter可以拦截所以请求
 */
public class DemoInterceptor implements HandlerInterceptor {

    /**
     * 在进入控制器之前执行
     * 如果返回为false,阻止进入控制器
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("handler:"+handler);
        System.out.println("preHandler");
        return true;
    }

    /**
     * 控制器执行完成，进入到jsp之前执行
     * 日志记录或敏感词过滤等
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("往"+modelAndView.getViewName()+"跳转");
        String word = modelAndView.getModel().get("model").toString();
        System.out.println("model的值"+word);
        modelAndView.getModel().put("model",word.replace("祖国","**"));
        System.out.println("postHandle");

    }

    /**
     * jsp执行完成后执行
     * 记录执行过程中出现的异常
     * 可以把异常记录到日志当中
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion"+ex.getMessage());
    }
}