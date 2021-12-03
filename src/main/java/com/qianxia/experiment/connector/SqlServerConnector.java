package com.qianxia.experiment.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author qianxia
 * @date 2021/11/30  18:48
 */
public class SqlServerConnector {

    private static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public static void main(String[] args) throws SQLException {
        try {
            //加载驱动
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=maleon", "sa", "Aa123456");
        ResultSet columnSet = connection.getMetaData().getColumns(connection.getCatalog(), null, "user", null);
        while (columnSet.next()) {
            System.out.println(columnSet.getString("REMARKS"));
            System.out.println(columnSet.getString(2));
            System.out.println(columnSet.getString(3));
            System.out.println(columnSet.getString(4));
            System.out.println(columnSet.getString(5));
            System.out.println(columnSet.getString(6));
            System.out.println(columnSet.getString(7));
            System.out.println(columnSet.getString(8));
            System.out.println(columnSet.getString(9));
            System.out.println(columnSet.getString(10));
        }
    }
}
