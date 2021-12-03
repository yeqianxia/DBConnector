package com.qianxia.experiment.connector;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.client.TableDescriptor;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Arrays;
import java.util.Set;

/**
 * @author qianxia
 * @date 2021/11/24  11:26
 */
public class HBaseConnector {



    public static void main(String[] args) throws Exception {
        Configuration configuration = HBaseConfiguration.create();
//        configuration.set("hbase.zookeeper.quorum", "172.16.11.132:2181,172.16.11.133:2181,172.16.11.134:2181");
        configuration.set("hbase.zookeeper.quorum", "bz-test-datasimba-cdh-02:2181,bz-test-datasimba-cdh-03:2181,bz-test-datasimba-cdh-04:2181");
        Connection connection = ConnectionFactory.createConnection(configuration);
        Admin admin = connection.getAdmin();
//        TableName[] tableNames = admin.listTableNamesByNamespace("maleon");
        TableName[] tableNames = admin.listTableNames();
        Arrays.stream(tableNames).sequential().forEach(tableName -> {
            try {
                System.out.println("表名为：" + Bytes.toString(tableName.getName()));

                Table table = connection.getTable(tableName);
                TableDescriptor descriptor = table.getDescriptor();
                Set<byte[]> columnFamilyNames = descriptor.getColumnFamilyNames();
//                columnFamilyNames.forEach(x -> {
//                    System.out.println("列族为：" + Bytes.toString(x));
//                    ResultScanner scanner = null;
//                    try {
//                        scanner = table.getScanner(x);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    Iterator<Result> iterator = scanner.iterator();
//                    if(iterator.hasNext()){
//                        System.out.println(111);
//                    }
//                    for (Result result : scanner) {
//                        NavigableMap<byte[], byte[]> familyMap = result.getFamilyMap(x);
//                        if (familyMap.size() == 0) {
//                            return;
//                        }
//                        for (Map.Entry<byte[], byte[]> entry : familyMap.entrySet()) {
//                            System.out.println("列名为：" + Bytes.toString(entry.getKey()));
//                        }
//                    }
//
//                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


    }

}


