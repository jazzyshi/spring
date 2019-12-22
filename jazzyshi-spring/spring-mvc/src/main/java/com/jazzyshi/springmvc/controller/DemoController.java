package com.jazzyshi.springmvc.controller;

import com.jazzyshi.springmvc.pojo.Demo;
import com.jazzyshi.springmvc.pojo.Demo1;
import com.jazzyshi.springmvc.pojo.People;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 1.在方法上只有@RequestMapping时，无论返回值是什么认为需要跳转
 * 2.在方法上添加@ResponseBody(恒不跳转)
 *   2.1 如果返回值满足key-value形式（对象或者map）
 *       2.1.1 把响应头设置为application/json;charset=utf-8
 *       2.1.2 把转化后的内容输出流的形式响应给客户端
 *   2.2 如果返回值的类容不满足key-value形式，例如返回值为string
 *       2.2.1 把响应头设置成text/html
 *       2.2.2 把方法返回值以流的形式直接输出
 *       2.2.3 如果方法返回值包含中文，出现中文乱码
 *               @RequestMapping (value="/xxx",produces="text/html;charset=utf-8")
 *   注意：底层使用jackson进行json转化，要导入jar包 注意版本
 */

@Controller
public class DemoController {

    @RequestMapping("demo")
    //默认保证参数名称和请求中传递的参数名相同
    public String demo(String name,int age){
        System.out.println("执行demo"+" "+name+" "+age);
        return "main.jsp";
    }

    @RequestMapping("demo1")
    //如果请求参数名和方法参数名不对应使用@RequestParam()赋值
    public String demo1(@RequestParam(value = "name1") String name,
                        @RequestParam("age1") int age){
        System.out.println("执行demo1"+" "+name+" "+age);
        return "main1.jsp";
    }
    @RequestMapping("demo2")
    //如果方法参数是基本数据类型（不是封装类）可以通过@RequestParam设置默认值----防止没有参数时500
    //如果强制要求必须有某个参数（required=true）
    public String demo2(@RequestParam(defaultValue = "2") int pageSize,
                        @RequestParam(defaultValue = "1",required = true) int pageNumber){
        System.out.println(pageSize + " " + pageSize);
        return "main2.jsp";
    }

    @RequestMapping("demo3")
    //请求参数名和对象中属性名对应（get/set方法）
    public String demo3(People peo){
        return "main.jsp";
    }

    @RequestMapping("demo4")
    //请求参数中包含多个同名参数的获取方式
    //复选框传递的参数就是多个同名参数
    public String demo4(@RequestParam("hover") List<String> abc){
        System.out.println(abc);
        return "main.jsp";
    }

    @RequestMapping("demo5")
    // <input type="text" name="peo.name"/>
    // <input type="text" name="peo.id"/>
    //请求参数是上面这种“对象.属性”格式，
    //需要新建一个类Demo，这个类Demo中对象名和参数点前面的名称对应 private People peo;
    public String demo5(Demo demo){
        System.out.println(demo);
        return "main.jsp";
    }

    @RequestMapping("demo6")
    // <input type="text" name="peo[0].name"/>
    // <input type="text" name="peo[0].id"/>
    // <input type="text" name="peo[1].name"/>
    // <input type="text" name="peo[1].id"/>
    //请求参数是上面集合对象类型，
    //需要新建一个类Demo1，这个类Demo中对象名和参数点前面的名称对应，
    //并且对象是private List<People> peo;的
    public String demo6(Demo1 demo1){
        System.out.println(demo1);
        return "main.jsp";
    }

    //restful传值方式：<a href="demo7/18/shijizhuo">
    //简化jsp中参数编写格式，在jsp中设定特殊格式
    //在控制器中要求：
    //1.@RequestMapping中一定要和请求格式对应
    //2.{名称}自定义
    //3.@PathVariable获取@RequestMapping中类容，默认按照方法参数名称去寻找
    @RequestMapping("demo7/{id1}/{name}")
    public String demo7(@PathVariable String name,@PathVariable("id1") int age){
        System.out.println(name + " " + age );
        return "";
    }

    /**
     * 跳转方式：
     * 1.默认调整方式请求转发
     * 2.设置返回值字符串类容
     *   2.1 重定向 添加"redirect:资源路径"
     *   2.2 转发   添加"forward:资源路径"或者省略forward:
     *
     * SpringMvc会提供默认的试图解析器
     * 程序员也可以自定义视图解析器 见jazzyshi-mvc.xml
     *
     * 如果不希望执行自定义视图解析器，在方法返回值的前面添加forward:或redirect:
     */
    @RequestMapping("demo8")
    public String demo8(){
        return "forward:demo9";
    }
    @RequestMapping("demo9")
    public String demo9(){
        System.out.println("demo9");
        return "main";
    }

    @ResponseBody
    @RequestMapping(value="demo10",produces="text/html;charset=utf-8")
    public String demo10(){
        People p = new People();
        p.setId(1+"");
        p.setName("史继卓");
        return "中文";
    }
}
