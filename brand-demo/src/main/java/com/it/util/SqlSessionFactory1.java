package com.it.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactory {
    private static org.apache.ibatis.session.SqlSessionFactory sqlSessionFactory;

    static {
        //静态代码块在类加载的时候就自动执行，且只执行一次
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    //使用已加载工厂能提升效率，类似线程池
    public static org.apache.ibatis.session.SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }

}