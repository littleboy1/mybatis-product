package com.lzq.mybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/*通知类必须实现iInvocationHandler*/
public class Invaction implements InvocationHandler {




    private  BaseService obj ; //当前被监控的对象

    public Invaction(BaseService obj) {
        this.obj = obj;
    }


    /**
     * 在被监控的行为将要执行的时候会被JVM拦截
     * 被监控的行为和行为的实现方会被作为参数输送给invoke****通知JVM。这个拦截方法如何将次要业务与主要业务绑定
     * @param proxy 代理对象（一般不用这个参数）
     * @param method 当前被拦截的方法
     * @param args 当前被拦截方法的参数
     * @return 返回当前方法的执行结果
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //确认当前被拦截的行为你声明局部变量接收返回值
        Object value ;
        if ("eat".equals(method.getName())){
            wash();
            value= method.invoke(obj,args);
        }else { //便后要洗手
            value=method.invoke(obj,args);
            wash();
        }
        return value;
    }

    public void wash(){
        System.out.println("---------祈祷------");
    }


}
