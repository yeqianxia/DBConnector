package com.qianxia.experiment.other;

import cn.hutool.crypto.SecureUtil;

/**
 * @author qianxia
 * @date 2021/12/8  17:54
 */
public class Other {


    public static void main(String[] args) {

        String password = "A6pms9mFnPZuE6q8iM4th70cDkw91zGJn5/mXoIQK3k=";

       String s =  SecureUtil.hmacMd5(password.trim()).digestHex(password.trim());
       System.out.println(s);
    }
}
