package com.lzq.mybatis.dao;


import com.lzq.mybatis.bean.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DeptMapper {

  Dept deptFindById(Integer dept);

  Dept deptFindByDeptNo(Integer deptNo);


}
