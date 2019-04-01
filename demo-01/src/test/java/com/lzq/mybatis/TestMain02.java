package com.lzq.mybatis;

import com.lzq.mybatis.bean.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestMain02 {

    @Test
    public void test01(){

        Dept dept = new Dept();

        dept.setdName("金融事业部");

        dept.setLoc("beijing");

        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sessionFactory.openSession();
            sqlSession.insert("insertDept",dept);
            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
