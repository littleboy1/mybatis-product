package com.lzq.mybatis;

import com.lzq.mybatis.bean.Dept;
import com.lzq.mybatis.dao.DeptMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Plugin;
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
        Dept dept = new Dept();
        dept.setdName("测试t7777");
        dept.setLoc("石家庄");
        dept.setFlag(true);
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        mapper.insertDept(dept);
        session.commit();
    }

    @Test
    public void test02(){
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        List<Dept> dept = mapper.deptFind();
        dept.forEach(dept1 -> System.out.println(dept1));

    }

    @After
    public void end(){
        if (session != null){
            session.close();
        }
    }
}
