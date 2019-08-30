package com.dabiao.util;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库连接工具类
 */
public class DBUtils {


    private static DataSource ds;

    static
    {
        ds = new ComboPooledDataSource();
    }

    // 获取数据库连接对象
    public static Connection getConnection() throws SQLException {

            return ds.getConnection();
    }

    // 获取c3p0数据库连接池对象
    public static DataSource getDataSource(){
        return ds;
    }

    // 释放资源
    public static void close(ResultSet rs, Statement stmt,Connection conn){

        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        if( stmt != null){

            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void close(Statement stmt,Connection conn){

        close(null,stmt,conn);

   /*     if( st != null){

            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/

    }

}
