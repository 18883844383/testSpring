package com.cqut.dao;

import junit.framework.TestCase;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {

private static SqlSessionFactory sf;
    
    static {
        //加载配置文件
        SqlSessionFactoryBuilder builder =
            new SqlSessionFactoryBuilder();
        sf = builder.build(TestCase.class.getClassLoader()
                .getResourceAsStream("SqlMapConfig.xml"));
    }
    
    /**
     *    创建连接
     */
    public static SqlSession getSession() {
        return sf.openSession();
    }
    public static void main(String[] args) {
        SqlSession session = MyBatisUtil.getSession();
        System.out.println(session);
        session.close();
    }
}
