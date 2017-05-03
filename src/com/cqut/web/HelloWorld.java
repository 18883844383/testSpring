package com.cqut.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*public class HelloWorld implements Controller{

	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		System.out.println("Hello, Controller.");
        return new ModelAndView("hello");
	}

}
*/
@Controller
public class HelloWorld {
	
	@RequestMapping("/hello.do")
	public ModelAndView hello(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        System.out.println("Hello, Controller.");
        return new ModelAndView("hello");
    }
	
	 @RequestMapping("/nihao.do")
	    public String nihao() {
	        System.out.println("你好");
	        return "hello";
	    }
}