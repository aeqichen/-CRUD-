package com.vio.service;


import com.vio.pojo.User;

import java.util.List;

public interface UserService{

    boolean addNewUser(User user);

    User findById(Integer id);

    User findByUsername(String username);

    boolean deleteByUsername(String username);

    boolean updateById(User user);

    boolean removeById(Integer id);

    void updatePassword(Integer id,String password);

    List getAllUser();

    void updateUsername(Integer id,String username);
}
