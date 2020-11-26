package com.tao.dao;

import com.tao.po.User;
import com.tao.util.JDBCUtil;
import com.tao.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public User login(String username,String password) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet result = null;
        User user = null;
        //jdbc--java发送sql语句到Mysql
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from user where username=? and password=?";
            pstm = conn.prepareStatement(sql);
            //设置参数
            pstm.setString(1,username);
            pstm.setString(2,password);
            //发送SQL语句
            result = pstm.executeQuery();
            if (result.next()) {
                user = new User();
                user.setId(result.getInt("id"));
                user.setUsername(result.getString("username"));
                user.setPassword(result.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                pstm.close();
                result.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return user;
    }

}
