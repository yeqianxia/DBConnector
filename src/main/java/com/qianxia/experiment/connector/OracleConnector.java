package com.qianxia.experiment.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author qianxia
 * @date 2021/11/30  20:42
 */
public class OracleConnector {

    private static String driverName = "oracle.jdbc.driver.OracleDriver";

    public static void main(String[] args) throws SQLException {
        try {
            //加载驱动
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
//        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@172.16.4.214:1521/ORCLCDB", "c##simba", "startdt1234");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "\"maleon\"", "111111");
//        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "system", "oracle");
//        System.out.println(connection.getMetaData().getCatalogs());
//        ResultSet tables = connection.getMetaData().getSchemas();
//        ResultSet tables = connection.getMetaData().getTables(null, "\"maleon\"", null, new String[]{"TABLE"});
        ResultSet tables = connection.getMetaData().getTables(null, connection.getMetaData().getUserName().replace("\"",""), null, new String[]{"TABLE"});

        ResultSet columns = connection.getMetaData().getColumns(null, connection.getMetaData().getUserName().replace("\"", ""), "USERINFO", null);


        while (tables.next()){
           System.out.println(tables.getString(1));
           System.out.println(tables.getString(2));
           System.out.println(tables.getString(3));
           System.out.println(tables.getString(4));
           System.out.println(tables.getString(5));
       }

        while (columns.next()){
            System.out.println(columns.getString("COLUMN_NAME"));
            System.out.println(columns.getString("TYPE_NAME"));
            System.out.println(columns.getString(3));
            System.out.println(columns.getString(4));
            System.out.println(columns.getString("REMARKS"));
        }


//        ResultSet tables = metaData.getTables(null, null, null, new String[]{"TABLE"});
//        if(tables.next()){
//            System.out.println(tables.getString(1));
//        }


//        while (tables.next()) {
//            System.out.println(tables.getString(1));
//            System.out.println(tables.getString(2));
//            System.out.println(tables.getString(3));
//            System.out.println(tables.getString(4));
//            System.out.println(tables.getString(5));
//            System.out.println(tables.getString(6));
//            System.out.println(tables.getString(7));
//            System.out.println(tables.getString(8));
//            System.out.println(tables.getString(9));
//            System.out.println(tables.getString(10));
//        }
    }
}
