package com.lzq.mybatis.dao;


import com.lzq.mybatis.bean.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DeptMapper {

    List<Dept> dept_1(Dept dept);
    List<Dept> dept_2(Dept dept);
    List<Dept> dept_3(Dept dept);
    int updateDept(Dept dept);

    int deptSave(List<Dept> depts);

    List<Dept> deptFindByList(List<Integer> deptNumbers);
    List<Dept> deptFindByArray(Integer[] deptNumbers);
    List<Dept> deptFindByMap(@Param("myMap") Map map);

}
