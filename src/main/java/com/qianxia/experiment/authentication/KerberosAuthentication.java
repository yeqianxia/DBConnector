package com.qianxia.experiment.authentication;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.security.UserGroupInformation;
import org.springframework.core.io.ClassPathResource;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author qianxia
 * @date 2021/12/3  10:02
 */
public class KerberosAuthentication {


    public void authentication() throws IOException {

        Configuration configuration = HBaseConfiguration.create();
        configuration.set("hbase.zookeeper.quorum", "bz-test-datasimba-cdh-02:2181,bz-test-datasimba-cdh-03:2181,bz-test-datasimba-cdh-04:2181");

        String krbStr = "/static/krb5.conf";
        String keyStr = "/static/simba.keytab";
        String kerberosPrincipal = "simba@STARTDT.NET";
        String serverPrincipal = "hbase/_HOST@STARTDT.NET";

        String authentication = "hadoop.security.authentication";
        String principal = "hbase.regionserver.kerberos.principal";

        configuration.set(authentication, principal);

        System.setProperty("java.security.krb5.conf", krbStr);

        UserGroupInformation.loginUserFromKeytab(kerberosPrincipal,keyStr);

    }

    public static void main(String[] args) throws IOException {
        Configuration configuration = HBaseConfiguration.create();
        configuration.set("hbase.zookeeper.quorum", "bz-test-datasimba-cdh-02:2181,bz-test-datasimba-cdh-03:2181,bz-test-datasimba-cdh-04:2181");

        String krbStr = "/Users/qianxia/IdeaProjects/Experiment/src/main/resources/static/krb5.conf";
        String keyStr = "/Users/qianxia/IdeaProjects/Experiment/src/main/resources/static/simba.keytab";
        String kerberosPrincipal = "simba@STARTDT.NET";

        String authentication = "hadoop.security.authentication";
        String principal = "kerberos";

        configuration.set(authentication, principal);

        System.setProperty("java.security.krb5.conf", krbStr);

        UserGroupInformation.setConfiguration(configuration);
        UserGroupInformation.loginUserFromKeytab(kerberosPrincipal,keyStr);
    }

}
