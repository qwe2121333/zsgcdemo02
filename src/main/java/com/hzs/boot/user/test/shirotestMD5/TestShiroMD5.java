package com.hzs.boot.user.test.shirotestMD5;

import org.apache.shiro.crypto.hash.Md5Hash;
import sun.security.provider.MD5;

public class TestShiroMD5 {
    public static void main(String[] args) {
        //创建一个MD5算法  此时并没有加密 散列？
//        Md5Hash md5Hash = new Md5Hash();
//        md5Hash.setBytes("123".getBytes());
//        String s = md5Hash.toHex();//toHex 转为16进制
//        System.out.println(s);
        //使用MD5 须使用构造方法
        Md5Hash md5Hash = new Md5Hash("123");
        System.out.println("无盐：" + md5Hash.toHex());

        //使用MD5 + salt处理
        Md5Hash md5Hash1 = new Md5Hash("123", "X0*7ps");
        System.out.println("有盐：" + md5Hash1.toHex());

        //使用MD5 + salt处理 + hash散列 散列越多越均匀，同时越安全，一般给予1024或者2048
        Md5Hash md5Hash2 = new Md5Hash("123", "X0*7ps", 1024);
        System.out.println("盐+散列：" + md5Hash2.toHex());
    }
}








