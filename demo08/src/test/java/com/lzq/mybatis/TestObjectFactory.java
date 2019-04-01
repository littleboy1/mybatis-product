package com.lzq.mybatis;

import com.lzq.mybatis.bean.Employee;
import com.lzq.mybatis.dao.EmpMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class TestObjectFactory {

    private SqlSession session;

    @Before
    public void start(){
        try {
            InputStream mybatisConfig = Resources.getResourceAsStream("mybatis-config.xml");
            InputStream mybatisProperties = Resources.getResourceAsStream("database.properties");
            Properties properties = new Properties();
            properties.load(mybatisProperties);
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(mybatisConfig,"development",properties);
            session = sessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * bean的封装
     * ResultSet = query()
     * while(ResultSet.next){
     *     Employee emp = employee.class.newInstance()
     *     Filed[] filedArray = emp.getClass().getDeclaredFields();
     *     for(int i = 0; i < filedArray.length; i ++){
     *         Field filedObject = fieldArray[i]
     *         String fieldName = fieldObject.getName()
     *         String value = ResultSet.getString(fieldName)
     *         Class fieldType = fieldObj.getType()
     *         if(Integer.class == fieldType){
     *             fieldObj.set(emp,Integer.valueOf(value))
     *         }else if (){}.....
     *     }
     * }
     */
    @Test
    public void test01(){

        EmpMapper mapper = session.getMapper(EmpMapper.class);
        List<Employee> depts = mapper.empFind();
        depts.forEach(employee -> System.out.println(employee));
        session.commit();
    }



    @After
    public void end(){
        if (session != null){
            session.close();
        }
    }
}
