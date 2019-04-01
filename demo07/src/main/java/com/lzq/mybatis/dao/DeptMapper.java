package com.lzq.mybatis.dao;

import com.lzq.mybatis.bean.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptMapper {

    List<Dept> deptFind(String param);
    List<Dept> deptFind2(@Param("tableName") String param);
}
