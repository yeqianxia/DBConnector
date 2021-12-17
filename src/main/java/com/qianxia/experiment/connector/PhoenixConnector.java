package com.qianxia.experiment.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Locale;

/**
 * @author qianxia
 * @date 2021/12/5  20:59
 */
public class PhoenixConnector {

    private static String driverName = "org.apache.phoenix.jdbc.PhoenixDriver";


    public static void main(String[] args) throws Exception {


//        String url = "jdbc:phoenix:bz-test-datasimba-cdh-02,bz-test-datasimba-cdh-03,bz-test-datasimba-cdh-04:2181";
//        String url = "jdbc:phoenix:172.16.87.249:2181";
//        String url = "jdbc:phoenix:bz-test-datasimba-cdh-02,bz-test-datasimba-cdh-03,bz-test-datasimba-cdh-04:2181/hbase";
//        String url = "jdbc:phoenix:localhost:2181/hbase";
//        String url = "jdbc:phoenix:123.60.37.235:13881:/hbase-unsecure";
//        String url = "jdbc:phoenix:123.60.37.235:2181:/hbase-unsecure";
//        String url = "jdbc:phoenix:172.16.87.249:16010";
//        String url = "jdbc:phoenix:172.16.87.251:2181:/hbase-unsecure";
        String url = "jdbc:phoenix:123.60.37.235:9581:/hbase-unsecure";
//        String url = "jdbc:phoenix:172.16.87.251,172.16.87.252,172.16.87.253:2181";
//        String url = "jdbc:phoenix:172.16.87.251,172.16.87.252,172.16.87.253:2181/hbase";
//        String url = "jdbc:phoenix:172.16.87.251,172.16.87.252,172.16.87.253:2181/hbase-unsecure";

        Class.forName(driverName);
        Connection connection = DriverManager.getConnection(url);
//        String createTableSql = "create view USERINFO(\n" +
//                "\t\"ROW\" VARCHAR PRIMARY KEY, \n" +
//                "\t\"id\".\"id\" VARCHAR, \n" +
//                "\t\"message\".\"name\" VARCHAR, \n" +
//                "\t\"message\".\"sex\" VARCHAR, \n" +
//                "        \"message\".\"age\" VARCHAR\n" +
//                ");\n" ;
//
//        PreparedStatement preparedStatement = connection.prepareStatement(createTableSql);
//        preparedStatement.execute();


//        System.out.println(connection.getCatalog());
//        System.out.println(connection.getSchema());
//
        ResultSet tables = connection.getMetaData().getTables(null, "SYSTEM", null, new String[]{"TABLE"});
        while (tables.next()) {
            System.out.println(tables.getString("table_name".toUpperCase()));
            System.out.println(tables.getString("remarks".toUpperCase()));
        }


    }

}
