package com.cqut.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class HelloController {
    @RequestMapping("/hello1.do")
    public ModelAndView hello(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        System.out.println("Hello, Controller.");
        return new ModelAndView("hello");
    }
}
