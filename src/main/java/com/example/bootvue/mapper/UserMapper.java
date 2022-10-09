package com.example.bootvue.mapper;

import com.example.bootvue.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    public List<User> findUser();

    @Insert("insert into user values (#{id},#{username},#{password},#{birthday})")
    public int insert(User user);
}
