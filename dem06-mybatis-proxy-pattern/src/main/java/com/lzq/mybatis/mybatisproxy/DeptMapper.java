package com.lzq.mybatis.mybatisproxy;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeptMapper implements SqlSession {
     private PreparedStatement ps ;

    @Override
    public int save(String sql) throws SQLException {
       int num =  ps.executeUpdate(sql);
        return num;
    }
}
