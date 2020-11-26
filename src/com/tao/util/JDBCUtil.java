package com.tao.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.*;

public class JDBCUtil {

    public static void main(String[] args) {
        new JDBCUtil().getCon();
    }
    public Connection getCon() {
        //加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //建立连接
        Connection conn = null;
        //ComboPooledDataSource dataSource = new ComboPooledDataSource();
        String url = "jdbc:mysql://localhost:3306/snake?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
        String user = "root";
        String password = "root";
        try {
            conn = DriverManager.getConnection(url, user, password);
            //-------------------------
            /*PreparedStatement pstm = conn.prepareStatement("insert into acount values (?,?,?)");
            pstm.setString(1,"小唐");
            pstm.setInt(2,4586);
            pstm.setDouble(3,618);
            pstm.executeUpdate();*/
            //-------------------------
            /*PreparedStatement pstm = conn.prepareStatement("delete from acount where username=?");
            pstm.setString(1, "小张");
            pstm.executeUpdate();*/
            //-------------------------
            PreparedStatement pstm = conn.prepareStatement("update acount set username=? where username=?");
            pstm.setString(1, "小李子");
            pstm.setString(2,"lisi");
            int result = pstm.executeUpdate();
            System.out.println(result);
            //-------------------------
            /*Statement st = conn.createStatement();
            ResultSet resultSet = st.executeQuery("select * from acount");
            while (resultSet.next()) {
                String us = resultSet.getString("username");
                String ps = resultSet.getString("password");
                String ra = resultSet.getString("rank");

                System.out.println(us+":"+ps+":"+ra);

            }*/

            //--------------------------
            pstm.close();
            /*resultSet.close();
            st.close();*/
            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
