package com.hzs.boot.user.service.Impl;

import com.hzs.boot.user.dao.UserDao;
import com.hzs.boot.user.entity.UserEntity;
import com.hzs.boot.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    //查询
    @Override
    public List<UserEntity> getAll(Map map){
      return userDao.getAll(map);
    }
    //根据id查询用户信息2
    @Override
    public List<UserEntity> getUserById2(Integer id) {
        System.out.println("UserEntity:");
        return userDao.getUserById2(id);
    }

    //删除
    @Override
    public void delById(Integer id) {
        userDao.delById(id);
    }

    //注册 Register
    @Override
    public void Register(UserEntity userEntity) {
        userEntity.setCreatetime(new Date());//日期
        userEntity.setStatus(1);//状态
        userDao.Register(userEntity);
    }
    //根据id查询用户信息
    @Override
    public UserEntity getUserById(Integer id) {
        return userDao.getUserById(id);
    }
    //根据id修改用户数据
    @Override
    public void updateUserById(UserEntity userEntity) {
        userDao.updateUserById(userEntity);
    }

}













