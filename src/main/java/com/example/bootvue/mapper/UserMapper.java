package com.example.bootvue.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bootvue.entity.User;
import com.example.bootvue.entity.UserOrder;
import com.example.bootvue.entity.UserOrderNum;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    public List<User> findUser();


    // mybatis实现多表查询
    //Results代表最终返回的结果集，当数据库字段名与实体类对应的属性名不一致时，可以使用@Results映射来将其对应起来
    //Result是结果中的每一项，这里有三个，代表想返回三个字段。其中id和username是user表的，order_num是torder表的
    //property代表实体类中对象的名称，column代表数据库中表的字段名
    //one与many是一对一与一对多的区别，利用column返回的字段值，调用目标mapper的方法进行查询，返回结果的类型需要与javaType设置相同
    @Select("select * from user")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "order_num", column = "uid", javaType = List.class,one = @One(select = "com.example.bootvue.mapper.UserOrderMapper.selectByUid"))
    })
    public List<UserOrderNum> findUserAndOrders();

    @Insert("insert into user values (#{id},#{username},#{password},#{birthday})")
    public int insert(User user);
}
