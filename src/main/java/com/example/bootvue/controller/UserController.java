package com.example.bootvue.controller;

import com.example.bootvue.entity.User;
import com.example.bootvue.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
