package com.qianxia.experiment.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author qianxia
 * @date 2021/11/30  10:15
 */
public class HiveConnect {

    private static String driverName = "org.apache.hive.jdbc.HiveDriver";

    public static void main(String[] args) throws SQLException {
        try {
            //加载驱动
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        Connection con = DriverManager.getConnection("jdbc:hive2://172.16.5.11:10000/maleon", "simba", "simba");
        System.out.println(con.getSchema());


        ResultSet tables = con.getMetaData().getTables(null, con.getSchema(), null, new String[]{"TABLE"});
        int i = 0;
        while (tables.next()) {
            System.out.println("表名为：" + tables.getString("TABLE_NAME"));
            System.out.println(tables.getString("REMARKS"));
            ResultSet columnSet = con.getMetaData().getColumns(con.getCatalog(), null, tables.getString("TABLE_NAME"), null);
            while (columnSet.next()) {
                System.out.println(columnSet.getString("COLUMN_NAME"));
                System.out.println(columnSet.getString("TYPE_NAME"));
                System.out.println(columnSet.getString("REMARKS"));
            }
            if (i++ > 5) {
                break;
            }
        }

        con.close();
    }


}
