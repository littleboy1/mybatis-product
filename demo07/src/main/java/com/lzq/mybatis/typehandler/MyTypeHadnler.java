package com.lzq.mybatis.typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyTypeHadnler implements TypeHandler {
    /*生成SQL语句时被调用*/
    @Override
    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        if (parameter == null){
            ps.setInt(i,0);
            return ;
        }else{
            Boolean flag = (Boolean) parameter;
            int intValue = flag == true ? 1 : 0;
            ps.setInt(i,intValue);
        }
    }
    /*查询结束之后调用将resultset转化为实体类对象*/
    @Override
    public Object getResult(ResultSet rs, String columnName) throws SQLException {

        int flag =  rs.getInt(columnName);

        return flag == 1 ? Boolean.TRUE :Boolean.FALSE;
    }
    /**/
    @Override
    public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }
}
