package com.cqut.web;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.Computer;
import entity.MobilePhone;
import entity.Student;

public class testCaseSetter {
	public static void main(String[] args){
	String cfg = "applicationContext.xml";
    AbstractApplicationContext ctx = 
        new ClassPathXmlApplicationContext(cfg);
    Computer computer = 
        ctx.getBean("computer", Computer.class);
    System.out.println(computer.getMainboard());
    System.out.println(computer.getHdd());
    System.out.println(computer.getRam());
    System.out.println("-----------------------------------");
    
    MobilePhone phone = 
            ctx.getBean("phone", MobilePhone.class);
        System.out.println(phone.getCpu());
        System.out.println(phone.getRam());
 
        System.out.println("-----------------------------------");
        Student student = 
                ctx.getBean("student", Student.class);
            System.out.println(student.getComputer());
            System.out.println(student.getMobilePhone());
    
            System.out.println("-----------------------------------");
	}
}
