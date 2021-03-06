package com.lzq.mybatis;

import com.lzq.mybatis.bean.Dept;
import com.lzq.mybatis.dao.DeptMapper;
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

    @Test
    public void test01(){

        DeptMapper mapper = session.getMapper(DeptMapper.class);
//        List<Dept> sales = mapper.deptFind("SALES");
        List<Dept> dept = mapper.deptFind2("dept");
        System.out.println(dept.size());
        session.commit();
    }



    @After
    public void end(){
        if (session != null){
            session.close();
        }
    }
}
