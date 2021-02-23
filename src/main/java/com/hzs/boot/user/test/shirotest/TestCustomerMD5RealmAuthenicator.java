package com.hzs.boot.user.test.shirotest;

import com.hzs.boot.user.test.shirotest.realm.CustomerRealmMD5Realm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

import java.util.Arrays;

public class TestCustomerMD5RealmAuthenicator {
    public static void main(String[] args) {
        //创建安全管理器
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        //注入realm
        CustomerRealmMD5Realm realm = new CustomerRealmMD5Realm();
        /**
         * 设置realm使用hash凭证匹配器  数据库返回的MD5，realm并没有变化
         * 这里明确了在使用reaml的时候在比较密码时，应该使用HashedCredentialsMatcher
         * 不能再用简单的了，简单的就是直接进行equals比较
         * HashedCredentialsMatcher会先对用户输入的明文进行md5加密，然后再进行equals比较
         */
        //设置realm使用hash凭证匹配器
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //使用的算法
        credentialsMatcher.setHashAlgorithmName("md5");
        //散列次数
        credentialsMatcher.setHashIterations(1024);
        realm.setCredentialsMatcher(credentialsMatcher);

        defaultSecurityManager.setRealm(realm);
        //将安全管理器注入安全工具
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        //通过安全工具类获取subject
        Subject subject = SecurityUtils.getSubject();
        //认证
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "123");
        try{
            subject.login(token);
            System.out.println("登陆成功");
        }catch (UnknownAccountException e){
            e.printStackTrace();
            System.out.println("用户名错误");
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("密码错误");
        }

        //授权
        if(subject.isAuthenticated()){
            //基于角色权限控制 编码，注解，标签
//            System.out.println(subject.hasRole("admin"));
            //基于多角色权限控制
//            System.out.println(subject.hasAllRoles(Arrays.asList("admin", "user")));
            //是否具有其中一个角色【基于角色】
//            boolean[] booleans = subject.hasRoles(Arrays.asList("admin", "super", "user"));
//            //快捷键 iter 循环遍历booleans是否存在以上三个角色
//            for (boolean aBoolean : booleans) {
//                System.out.println("角色"+aBoolean);
//            }
            //基于权限字符串的访问控制 资源标识符:操作:资源类型
//            System.out.println("==============================================================");
//            System.out.println("user权限:"+subject.isPermitted("user:update:01"));
//            System.out.println("product,create权限:"+subject.isPermitted("product:create:02"));//System.out.println("product权限:"+subject.isPermitted("product:update:02"));
            //分别具有哪些权限
            System.out.println("分别具有哪些权限");
            boolean[] permitted = subject.isPermitted("user:*:01", "order:*:10");
            for (boolean b : permitted) {
                System.out.println(b);
            }
            //同时具有哪些权限
            System.out.println("同时具有哪些权限");
            boolean permittedAll = subject.isPermittedAll("user:*:01", "product:create:02");
            System.out.println(permittedAll);

        }
    }
}










