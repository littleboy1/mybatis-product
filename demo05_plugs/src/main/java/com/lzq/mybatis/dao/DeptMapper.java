package com.lzq.mybatis.dao;

import com.lzq.mybatis.bean.Dept;

import java.util.List;

public interface DeptMapper {

    void insertDept(Dept dept);

    List<Dept> deptFind();
}
