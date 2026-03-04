package com.vio.service.serviceIml;

import com.vio.mapper.UserMapper;
import com.vio.service.UserService;
import com.vio.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceIml implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean addNewUser(User user) {
        return userMapper.addNewUser(user);
    }

    @Override
    public User findById(Integer id) {
        return  userMapper.findById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public boolean deleteByUsername(String username) {
        return userMapper.deleteByUsername(username);
    }

    @Override
    public boolean updateById(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public boolean removeById(Integer id) {
        return userMapper.removeById(id);
    }

    @Override
    public void updatePassword(Integer id ,String password) {
        userMapper.updatePassword(id, password);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public void updateUsername(Integer id,String username) {
        userMapper.updateUsername(id,username);
    }
}
