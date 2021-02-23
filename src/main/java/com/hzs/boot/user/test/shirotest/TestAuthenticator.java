package com.hzs.boot.user.test.shirotest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

/**
 * shiro的第一次测试
 * 测试数据：resource/shiro.ini
 */
public class TestAuthenticator {
    public static void main(String[] args) {
        //1,创建安全管理器对象
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        //2,给安全管理器设置realm
        securityManager.setRealm(new IniRealm("classpath:shiro.ini"));
        /**
         * 3,SecurityUtils 给全局安全工具类设置安全管理器，
         * 日后认证时，都需要借助SecurityUtils完成认证
         */
        SecurityUtils.setSecurityManager(securityManager);
        /**
         * 4,认证流程中的关键对象之一：subject（当前登陆的主体）
         */
        Subject subject = SecurityUtils.getSubject();
        /**
         * 5，创建令牌 Token：身份信息，凭证信息
         * UnknownAccountException 用户名错误
         *IncorrectCredentialsException 密码错误
         */
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan","123");
        try{
            System.out.println("认证状态前"+subject.isAuthenticated());
            subject.login(token);//用户认证
            System.out.println("认证状态："+subject.isAuthenticated()+"：认证成功");
        }catch (UnknownAccountException e){
            e.printStackTrace();
            System.out.println("认证状态：用户名不存在");
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("认证状态：密码错误");
        }
    }
}

























