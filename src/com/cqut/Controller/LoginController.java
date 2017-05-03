package com.cqut.Controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cqut.entity.Admin;
import com.cqut.exception.AdminCodeException;
import com.cqut.exception.PasswordException;
import com.cqut.service.LoginService;

@Controller
public class LoginController implements Serializable {
	
	@Resource
	private LoginService loginService;
	
	@ExceptionHandler
    public String execute(HttpServletRequest request,
            HttpServletResponse response, Exception e) throws Exception {
        if(e instanceof AdminCodeException
                || e instanceof PasswordException) {
            //业务异常自己处理
            request.setAttribute("message", e.getMessage());
            request.setAttribute(
                "adminCode", request.getParameter("adminCode"));
            request.setAttribute(
                "password", request.getParameter("password"));
            return "login";
        } else {
            //系统异常抛出，交给Spring处理
            throw e;
        }
    }
	
	
    @RequestMapping("toLogin.do")
    public String toLogin() {
        return "login";
    }
    
    @RequestMapping("toIndex.do")
    public String toIndex(){
    	return "index";
    }
    
    @RequestMapping("checkLogin")
    public String checkLogin(String adminCode, String password, 
            ModelMap model, HttpSession session) {
        /*try {
            Admin admin = 
                loginService.checkAdminCodeAndPwd(adminCode, password);
            session.setAttribute("admin", admin);
        } catch (AdminCodeException e) {
            model.addAttribute("message", e.getMessage());
            model.addAttribute("adminCode", adminCode);
            model.addAttribute("password", password);
            return "login";
        } catch (PasswordException e) {
            model.addAttribute("message", e.getMessage());
            model.addAttribute("adminCode", adminCode);
            model.addAttribute("password", password);
            return "login";
        }*/
    	//Integer.valueOf("abc");
    	Admin admin=loginService.checkAdminCodeAndPwd(adminCode, password);
    	session.setAttribute("admin", admin);
        return "redirect:toIndex.do";
    }
    
    @RequestMapping("/find.do")
    public String find(ModelMap model) {
        List<Admin> list = loginService.findAll();
        model.addAttribute("admins", list);
        return "index";
    }
    
}
