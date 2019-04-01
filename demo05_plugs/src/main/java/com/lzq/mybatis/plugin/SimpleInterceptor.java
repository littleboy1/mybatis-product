package com.lzq.mybatis.plugin;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

@Intercepts({
        @Signature(method = "query",type = Executor.class,args = {MappedStatement.class,Object.class, RowBounds.class, ResultHandler.class,})
})
public class SimpleInterceptor implements Interceptor {
    /***
     * 参数invocation代理对象   被监控的方法   当前被监控方法运行时需要的实参
     *
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("被拦截的方法执行之前**********************");

        Object obj = invocation.proceed();

        System.out.println("被拦截的方法执行之后---------------");

        return obj;
    }

    /**
     *
     * @param target 被拦截的对象 应该executor接口的实例对象
     *               作用：如果被拦截的对象所在的类有实现接口就为当前拦截对象生成一个代理对象
     *               若果被拦截对象所在类里面没有指定的接口这个对象之后的行为不会被代理操作
     * @return
     */
    @Override
    public Object plugin(Object target) {
        return  Plugin.wrap(target,this);
    }
    //讀取配置文件放的属性信息
    @Override
    public void setProperties(Properties properties) {

    }
}
