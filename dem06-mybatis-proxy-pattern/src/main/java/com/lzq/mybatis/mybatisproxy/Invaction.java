package com.lzq.mybatis.mybatisproxy;



import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/*通知类必须实现iInvocationHandler*/
public class Invaction implements InvocationHandler {


    private Connection connection;

    private  PreparedStatement ps;

    private  SqlSession obj ; //当前被监控的对象

    public Invaction(SqlSession obj) {
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
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
        //确认当前被拦截的行为你声明局部变量接收返回值
        init(args[0].toString());
        Field field = obj.getClass().getDeclaredField("ps");
        field.setAccessible(true);
        field.set(obj,ps);
        Object value = method.invoke(obj,args);
        close();
        return value;
    }

    public void init(String sql) throws Exception {
       Class.forName("com.mysql.cj.jdbc.Driver");
         connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studymybatis","root","admin");
         ps = connection.prepareStatement(sql);
    }

    public void close() throws Exception{
        if (connection != null){
            connection.close();
        }
        if (ps != null ){
            ps.close();
        }
    }
}
