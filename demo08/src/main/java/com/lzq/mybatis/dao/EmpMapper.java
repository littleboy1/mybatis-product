package com.lzq.mybatis.dao;

import com.lzq.mybatis.bean.Employee;

import java.util.List;

public interface EmpMapper {
    public List<Employee> empFind();
}
