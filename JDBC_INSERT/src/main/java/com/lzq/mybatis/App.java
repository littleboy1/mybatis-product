package com.lzq.mybatis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("加载成功");
        Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/studymybatis","root","admin");
        con.setAutoCommit(false);
        PreparedStatement preparedStatement = con.prepareStatement("insert  into dept values (?,?,?)");
        preparedStatement.setInt(1,1009);
        preparedStatement.setString(2,"test1");
        preparedStatement.setString(3,"test2");
        preparedStatement.executeUpdate();
        con.commit();
    }
}
