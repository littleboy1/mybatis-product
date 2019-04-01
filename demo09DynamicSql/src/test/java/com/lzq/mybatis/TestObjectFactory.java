package com.lzq.mybatis;

import com.lzq.mybatis.bean.Dept;
import com.lzq.mybatis.bean.Employee;
import com.lzq.mybatis.dao.DeptMapper;
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
import java.util.*;

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

        DeptMapper mapper = session.getMapper(DeptMapper.class);
        Dept dept = new Dept();
        dept.setDeptNo(20);
        dept.setdName("SE");
        List<Dept> depts = mapper.dept_1(dept);
        depts.forEach(dept1 -> System.out.println(dept1));

    }
    @Test
    public void test02(){

        EmpMapper mapper = session.getMapper(EmpMapper.class);
        Employee employee = new Employee();
        employee.setSal(1000+"");
        List<Employee> employees = mapper.empFind(employee);
        employees.forEach(employee1 -> System.out.println(employee1));

    }

    @Test
    public void test03(){

        DeptMapper mapper = session.getMapper(DeptMapper.class);
        Dept dept = new Dept();
//        dept.setDeptNo(20);
        dept.setdName("ES");
        List<Dept> depts = mapper.dept_2(dept);
        depts.forEach(dept1 -> System.out.println(dept1));

    }



    @Test
    public void test04(){

        DeptMapper mapper = session.getMapper(DeptMapper.class);
        Dept dept = new Dept();
        dept.setDeptNo(20);
        dept.setdName("新部门");
        int  depts = mapper.updateDept(dept);
        System.out.println(depts);
    }

    @Test
    public void test05(){

        DeptMapper mapper = session.getMapper(DeptMapper.class);
        Dept dept = new Dept();

        dept.setdName("ACCOUNTING");
        dept.setLoc("Beijing");
        List<Dept> depts = mapper.dept_3(dept);
        depts.forEach(dept1 -> System.out.println(dept1));

    }

    @Test
    public void test06(){

        DeptMapper mapper = session.getMapper(DeptMapper.class);
        Dept dept = new Dept();
        dept.setdName("ACCOUNTING22");
        dept.setLoc("Beijing222");
        Dept dept2 = new Dept();
        dept2.setdName("ACCOUNTING999");
        dept2.setLoc("Beijing999");
        List<Dept> list = new ArrayList<>();
        list.add(dept);
        list.add(dept2);
        mapper.deptSave(list);
        session.commit();

    }

    @Test
    public void test07(){
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        List<Integer> list = new ArrayList<>();
        list.add(40);
        list.add(50);
        List<Dept> depts = mapper.deptFindByList(list);
        depts.forEach(dept -> System.out.println(dept));

    }

    @Test
    public void test08(){
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        Integer[] array = new Integer[2];
        array[0]=40;
        array[1]=42;
        List<Dept> depts = mapper.deptFindByArray(array);
        depts.forEach(dept -> System.out.println(dept));

    }

    @Test
    public void test09(){
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        Map<String,Object> sqlParams = new HashMap<>();
        sqlParams.put("aa",40);
        sqlParams.put("bb",50);
        List<Dept> depts = mapper.deptFindByMap(sqlParams);
        depts.forEach(dept -> System.out.println(dept));

    }

    @After
    public void end(){
        if (session != null){
            session.close();
        }
    }
}
