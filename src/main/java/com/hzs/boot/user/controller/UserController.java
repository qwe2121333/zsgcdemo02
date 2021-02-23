package com.hzs.boot.user.controller;

import com.hzs.boot.user.entity.UserEntity;
import com.hzs.boot.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;
import java.util.Map;
//mysql---右键---复制sql---美化sql
//Controller---Service---ServiceImpl---Dao---Mapper
//@RestController 响应重定向不能返回json数据
@Controller
//请求映射指：Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;
    //查询
    @ResponseBody//由于删除了RestController，而查询必须要返回json，所以加一个ResponseBody
    @RequestMapping("/getAll")
    public List<UserEntity> getAll(Map map){
        return userService.getAll(map);
    }

    //根据id查询用户信息2
    @RequestMapping("/getUserById2")
    public String getUserById2(Integer id){
        System.out.println("id:"+id);
        userService.getUserById2(id);
        return "redirect:/update.html";
    }
    //删除
    @RequestMapping("/delById")
    public String delById(Integer id){
        System.out.println(id+"删除成功");
        userService.delById(id);
        //return "success";
        return "redirect:/index.html";//响应重定向
    }


    /**
     *注册
     * 前端给后端发送数据，没有实体类的概念
     * @RquestBody 可以理解为将一个json数据比作实体类
     * json是可以转换成实体类的，将这个数据赋值到userEntity这个实体类中
     */
    @RequestMapping("/save")
    @ResponseBody//spring boot中return"success"的话会让其误认为跳转到一个页面，
                 // 而我们著需要它返回一条成功“success”的数据。
    public String Register(@RequestBody UserEntity userEntity){
        userService.Register(userEntity);
        System.out.println("新增"+userEntity.toString());
        return "success";
    }


    /**
     * 根据id查询用户信息
     * 修改相当于查询和修改的结合
     */
    @RequestMapping("/getUserById")
    @ResponseBody
    public UserEntity getUserById(Integer id){
        return userService.getUserById(id);
    }
    /**
     * 根据id修改用户信息
     * 修改相当于查询和修改的结合
     * @return
     */
    @RequestMapping(value="/updateUserById",method = RequestMethod.POST)
    @ResponseBody
    public String updateUserById(@RequestBody UserEntity userEntity){//此处类似著恶策保存
        System.out.println(userEntity);
        userService.updateUserById(userEntity);
        System.out.println(userEntity);
        return "success";
    }
}




















