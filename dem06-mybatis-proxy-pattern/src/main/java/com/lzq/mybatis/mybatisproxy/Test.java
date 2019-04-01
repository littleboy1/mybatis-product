package com.lzq.mybatis.mybatisproxy;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws SQLException {
        SqlSession dao = SqlSessionFactory.build(DeptMapper.class);
        String sql = "insert into dept values (51,'TEST','beijing',1)";
        Map statmentMapper = new HashMap();
        statmentMapper.put("dept.save",sql);
        dao.save(statmentMapper.get("dept.save").toString());
    }
}
