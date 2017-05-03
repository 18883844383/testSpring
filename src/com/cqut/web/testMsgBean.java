package com.cqut.web;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.DemoBean;
import entity.MessageBean;

public class testMsgBean {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String cfg = "applicationContext.xml";
	    AbstractApplicationContext ctx = 
	        new ClassPathXmlApplicationContext(cfg);
	    
//	    MessageBean bean1 = ctx.getBean("msg2", MessageBean.class);
//        bean1.execute();
        
        DemoBean bean2 = ctx.getBean("demo", DemoBean.class);
        bean2.execute();
	}

}
