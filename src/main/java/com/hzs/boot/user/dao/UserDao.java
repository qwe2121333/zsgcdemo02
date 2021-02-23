package com.hzs.boot.user.dao;

import com.hzs.boot.user.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDao {
    //查询
    List<UserEntity> getAll(@Param("content")Map map);
    //根据id查询用户信息2
    List<UserEntity> getUserById2(@Param("id")Integer id);
    //删除
    void delById(Integer id);
    //注册 Register
    public void Register(UserEntity userEntity);
    //根据id查询用户信息
    public UserEntity getUserById(Integer id);
    //根据id修改用户数据
    public void updateUserById(UserEntity userEntity);
}
