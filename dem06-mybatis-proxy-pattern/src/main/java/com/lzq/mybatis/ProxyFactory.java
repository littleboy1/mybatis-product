package com.lzq.mybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    /**
     * jdk动态代理模式下，代理对象的数据类型应该由监控的行为来描述
     */
    public static  BaseService  build(Class clazz){
        BaseService baseService;
        //创建被监控的实例对象
        //创建通知对象
        InvocationHandler invaction;
        try {
            baseService = (BaseService) clazz.newInstance();
            //创建一个通知对象
            invaction  = new Invaction(baseService);
            //想JVM申请一个负责监控OBJ对象中指定行为的监控对象
            //*
            // loader被监控对象在内存中的真实地址
            //baseService.getClass()返回的是引用对象该对象指向内存中的地址getClassLoader()返回内存中的地址
            // */
            BaseService $proxy = (BaseService) Proxy.newProxyInstance(baseService.getClass().getClassLoader(),baseService.getClass().getInterfaces(),invaction);
            return $proxy;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}
