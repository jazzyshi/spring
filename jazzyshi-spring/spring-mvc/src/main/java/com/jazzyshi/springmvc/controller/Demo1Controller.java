package com.jazzyshi.springmvc.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 一、JSP九大内置对象
 * 名称        类型                 含义              获取方式
 * 1.request   HttpServletRequest  封装所以请求信息   方法参数
 * 2.response  HttpServletResponse 封装所有响应信息   方法参数
 * 3.session   HttpSession         封装所有会话信息    req.getSession
 * 4.application ServletContext    所有信息           getServletContext();request.getServletContext()
 * 5.out        PrintWriter        输出对象           response.getWriter()
 * 6.exception  Exception          异常对象
 * 7.page       Object              当前页面对象
 * 8.pageContext PageContext        获取其他对象
 * 9.config     ServletConfig       配置信息
 * 二、四大作用域
 * 1.page:在当前页面不会重新实力化
 * 2.request:在一次请求中是同一个对象，下次请求重新实例化一个对象
 * 3.session:一次会话，只要客户端Cookie中传递的jsessionid不变，session不重新实例化（不超过默认缓存失效时间）
 *   实际有效时间:浏览器关闭，Cookie失效；默认时间内无任何交互。在web.xml中配置的session-timeout
 * 4.application:只要在tomcat启动时才实例化，关闭tomcat时销毁application
 *
 * 三、作用域4种传值方式：请看下面的方法上说明
 */
@Controller
public class Demo1Controller {

    //1.适应原生Servlet 在HandlerMethod参数中添加作用域对象
    @RequestMapping("demo1")
    public String demo1(HttpServletRequest req, HttpSession session){
        //request作用域
        req.setAttribute("req","req的值");
        //session作用域
        HttpSession s = req.getSession();
        s.setAttribute("session","session的值");
        session.setAttribute("session","session的值");
        //application作用域
        ServletContext application = req.getServletContext();
        application.setAttribute("application","application的值");
        return "main.jsp";
    }

    //2.使用map组合：
    // 2.1把map中内容放在request作用域中
    // 2.2spring会对map集合通过BindingAwareModelMap进行实例化
    @RequestMapping("demo2")
    public String demo2(Map<String,Object> map){
        System.out.println(map.getClass());
        map.put("map1","map1的值");
        map.put("map2","map2的值");
        return "main.jsp";
    }

    //3.使用SpringMVC中Model接口
    @RequestMapping("demo3")
    public String demo3(Model model){
        model.addAttribute("modelA","model的值");
        return "main.jsp";
    }

    //4.使用SpringMVC中ModelAndView接口
    @RequestMapping("demo4")
    public ModelAndView demo4(){
        ModelAndView modelAndView = new ModelAndView("main.jsp");
        modelAndView.addObject("mav","mav的值");
        return modelAndView;
    }
}
