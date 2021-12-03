package com.qianxia.experiment.connector;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.ColumnFamilyDescriptor;
import org.apache.hadoop.hbase.client.ColumnFamilyDescriptorBuilder;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.TableDescriptor;
import org.apache.hadoop.hbase.client.TableDescriptorBuilder;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author qianxia
 * @date 2021/11/29  15:33
 */
public class HBaseTableCreate {

    public static void main(String[] args) throws IOException {
        Configuration configuration = HBaseConfiguration.create();
//        configuration.set("hbase.zookeeper.quorum", "172.16.11.132:2181,172.16.11.133:2181,172.16.11.134:2181");
        configuration.set("hbase.zookeeper.quorum", "bz-test-datasimba-cdh-02:2181,bz-test-datasimba-cdh-03:2181,bz-test-datasimba-cdh-04:2181");
        Connection connection = ConnectionFactory.createConnection(configuration);
        Admin admin = connection.getAdmin();
//        TableName student = TableName.valueOf("studentInfo");
//        if(admin.tableExists(student)){
//            admin.disableTable(student);
//            admin.deleteTable(student);
//        }

        TableName student = TableName.valueOf("maleon:studentInfo");

        ColumnFamilyDescriptorBuilder columnFamilyDescriptorBuilder = ColumnFamilyDescriptorBuilder.newBuilder("class".getBytes(StandardCharsets.UTF_8));
        ColumnFamilyDescriptor columnFamilyDescriptor = columnFamilyDescriptorBuilder.build();

        ColumnFamilyDescriptorBuilder columnFamilyDescriptorBuilder1 = ColumnFamilyDescriptorBuilder.newBuilder("info".getBytes(StandardCharsets.UTF_8));
        ColumnFamilyDescriptor columnFamilyDescriptor1 = columnFamilyDescriptorBuilder1.build();


        TableDescriptor tableDescriptor = TableDescriptorBuilder.newBuilder(student).setColumnFamily(columnFamilyDescriptor).setColumnFamily(columnFamilyDescriptor1).build();
        admin.createTable(tableDescriptor);

        Put put = new Put(Bytes.toBytes("0001"));
        put.addColumn(Bytes.toBytes("class"),Bytes.toBytes("math"),Bytes.toBytes("100"));
        put.addColumn(Bytes.toBytes("class"),Bytes.toBytes("english"),Bytes.toBytes("90"));
        put.addColumn(Bytes.toBytes("class"),Bytes.toBytes("chemistry"),Bytes.toBytes("80"));
        put.addColumn(Bytes.toBytes("class"),Bytes.toBytes("physics"),Bytes.toBytes("95"));
        put.addColumn(Bytes.toBytes("info"),Bytes.toBytes("age"),Bytes.toBytes("20"));
        put.addColumn(Bytes.toBytes("info"),Bytes.toBytes("gender"),Bytes.toBytes("male"));
        put.addColumn(Bytes.toBytes("info"),Bytes.toBytes("name"),Bytes.toBytes("tester"));
        put.addColumn(Bytes.toBytes("info"),Bytes.toBytes("phone"),Bytes.toBytes("18589383037"));
        connection.getTable(student).put(put);

    }
}
