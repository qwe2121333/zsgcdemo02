package com.hzs.boot.user.service;

import com.hzs.boot.user.entity.UserEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public interface UserService {
    //查询
    List<UserEntity> getAll(Map map);
    //根据id查询用户信息2
    public List<UserEntity> getUserById2(Integer id);

    //删除
    void delById(Integer id);

    /**
     * 注册 Register
     * 当有返回值的时候使用String
     * 此时注册没有返回值，可以用void替代
     */
    public void Register(UserEntity userEntity);
    //根据id查询用户信息
    public UserEntity getUserById(Integer id);
    //根据id修改用户数据
    public void updateUserById(@RequestBody UserEntity userEntity);
}













