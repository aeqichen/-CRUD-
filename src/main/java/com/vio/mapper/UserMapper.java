package com.vio.mapper;

import com.vio.pojo.User;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("insert into user(username,password,email) values(#{username} ,#{password} ,#{email})")
    boolean addNewUser(User user);

    @Select("select * from user where id = #{id}")
    User findById(Integer id);

    @Select("select * from user where username = #{username}")
    User findByUsername(String username);

    @Delete("delete from user where username = #{username}")
    boolean deleteByUsername(String username);

    @Update("update user set username = #{username} , password = #{password} , email = #{email} where id = #{id}")
    boolean updateById(User user);

    @Delete("delete from user where id = #{id}")
    boolean removeById(Integer id);

    @Update("update user set password = #{password} where id = #{id}")
    void updatePassword(Integer id, String password);

    @Select("select * from user")
    List<User> getAllUser();

    @Update("update user set username = #{username} where id = #{id}")
    void updateUsername(Integer id,String username);

    @Update("update user set email = #{email} where id = #{id}")
    void updateEmail(Integer id, String email);
}
