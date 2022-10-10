package com.example.bootvue.mapper;

import com.example.bootvue.entity.UserOrder;
import com.example.bootvue.entity.UserOrderNum;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserOrderMapper {

    @Select("select * from torder where uid=#{uid}")
    public List<UserOrder> selectByUid();
}
