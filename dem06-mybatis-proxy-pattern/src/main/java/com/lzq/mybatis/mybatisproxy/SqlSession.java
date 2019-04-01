package com.lzq.mybatis.mybatisproxy;

import java.sql.SQLException;

public interface SqlSession {

    int save(String sql) throws SQLException;
}
