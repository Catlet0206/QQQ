package com.example.demo;

import org.springframework.web.bind.annotation.*;
import sun.net.httpserver.HttpServerImpl;

import javax.servlet.http.HttpServletRequest;

@RestController
//表示该controller类下所有的方法都公用的一级上下文根
@RequestMapping("/cs")
public class HelloWorld {
    //这里使用@RequestMapping注解表示该方法对应的二级上下文路径
    @RequestMapping(value = "/hello")
    public String HelloSpring(){
        System.out.println("hello tian");
        return "hello tian" ;
    }

    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    public String index(@RequestParam(value = "name", required = false) String name, HttpServletRequest request){
        String test = request.getHeader("test");

        System.out.println("hello" + name);
        System.out.println("header:" + test);
        return "hello " + name + ", this is first message";
    }

    @RequestMapping("/auth/is_authorized")
    public boolean isAuthorized(@RequestParam(name = "uri") String uri, @RequestParam(name="userId")String userId){
        if(userId.equals("0"))
            return false;
        return true;
    }
}
