package com.itlogin.mapper;

import com.itlogin.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    //查询是否有这个用户数据
    @Select("select * from User where username=#{username} and password=#{password}")
    User select(@Param("username") String username, @Param("password") String password);

    //查询用户名是否存在
    @Select("select username from User where username=#{username}")
    User sbyusername(@Param("username")String name);

    //添加用户数据
    @Insert("insert into User values (null,#{username},#{password})")
    void add(User user);
}
