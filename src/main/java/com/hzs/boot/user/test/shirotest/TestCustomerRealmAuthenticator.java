package com.hzs.boot.user.test.shirotest;

import com.hzs.boot.user.test.shirotest.realm.CustomerRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * 使用自定义realm
 */
public class TestCustomerRealmAuthenticator {
    public static void main(String[] args) {
        //创建securityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        //设置自定义realm
        defaultSecurityManager.setRealm(new CustomerRealm());
        //将安全工具类设置安全工具类
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        //通过安全工具类获取subject
        Subject subject = SecurityUtils.getSubject();
        //创建token
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "123");

        try{
            subject.login(token);//用户认证
            System.out.println("认证状态："+subject.isAuthenticated()+"：认证成功");
        }catch (UnknownAccountException e){
            e.printStackTrace();
            System.out.println("认证状态：用户名不存在");
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("认证状态：密码错误");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}







