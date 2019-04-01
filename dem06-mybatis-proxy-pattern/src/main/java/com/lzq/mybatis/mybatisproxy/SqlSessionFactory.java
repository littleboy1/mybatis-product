package com.lzq.mybatis.mybatisproxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class SqlSessionFactory {

    public static SqlSession build(Class clazz){
        SqlSession sqlSession;
        //创建被监控的实例对象
        //创建通知对象
        InvocationHandler invaction;
        try {
            sqlSession = (SqlSession) clazz.newInstance();
            //创建一个通知对象
            invaction  = new Invaction(sqlSession);
            //想JVM申请一个负责监控OBJ对象中指定行为的监控对象
            //*
            // loader被监控对象在内存中的真实地址
            //baseService.getClass()返回的是引用对象该对象指向内存中的地址getClassLoader()返回内存中的地址
            // */
            SqlSession $proxy = (SqlSession) Proxy.newProxyInstance(sqlSession.getClass().getClassLoader(),sqlSession.getClass().getInterfaces(),invaction);
            return $proxy;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

}
