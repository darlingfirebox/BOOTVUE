package com.example.bootvue.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bootvue.entity.User;
import com.example.bootvue.entity.UserOrder;
import com.example.bootvue.entity.UserOrderNum;
import com.example.bootvue.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// RestController与Controller的区别在于返回的对象类型不同
// RestController返回json对象、字符串等等，Controller返回页面
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping(value = "/user")
    public List query(){
        List<User> users = userMapper.findUser();
        System.out.println(users);
        return users;
    }

    @GetMapping(value = "/userorder")
    public List queryorder(){
        List<UserOrderNum> userOrder = userMapper.findUserAndOrders();
        System.out.println(userOrder);
        return userOrder;
    }


    @PostMapping(value = "/new-user")
    public String save(User user){
        int i = userMapper.insert(user);
        if (i>0){
            System.out.println("插入成功！");
            return "插入成功！";
        }
        else {
            return "插入失败！";
        }
    }
}
