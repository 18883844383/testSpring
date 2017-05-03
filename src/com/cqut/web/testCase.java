package com.cqut.web;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.ExampleBean;

public class testCase {

	
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext(
						"applicationContext.xml");
				//System.out.println(ac);
				Calendar cal1=(Calendar) ac.getBean("obj1");
				System.out.println(cal1);
				
				Calendar cal2=ac.getBean("obj2",Calendar.class);
				System.out.println(cal2);
				
				Date date=ac.getBean("obj4",Date.class);
				System.out.println(date);
				
				
		        ExampleBean bean1 = 
		            ac.getBean("example", ExampleBean.class);
		        System.out.println(bean1);
				
		        ExampleBean bean2 = 
		                ac.getBean("example", ExampleBean.class);
		            System.out.println(bean1==bean2);
	}

}
