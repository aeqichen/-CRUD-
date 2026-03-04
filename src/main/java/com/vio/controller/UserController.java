package com.vio.controller;


import com.vio.DTO.UserDTO;
import com.vio.service.UserService;
import com.vio.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    //添加user
    @PostMapping("/addUser")
    public String addUser(@Validated @RequestBody UserDTO userDTO) {
        User user = new User();

        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setUsername(userDTO.getUsername());
        boolean result = userService.addNewUser(user);
        if (result) {
            return "用户添加成功！";
        }else {
        return "用户添加失败";}
    }

    //查询所有用户
    @GetMapping("/getAllUser")
    public List<User> getAllUser() {
        List<User> list = new ArrayList<>();
        list.addAll(userService.getAllUser());
        return list;
    }

    //根据id查询用户
    @GetMapping("userinfo/{id}")
    public User findById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    //根据用户名查询用户
    @PostMapping("/getByUsername")
    public User findByUsername(@RequestParam String username) {
        return userService.findByUsername(username);
    }

    //根据id更新用户
    @PutMapping("/updateById/{id}")
    public String updateByUser(@PathVariable Integer id,@Validated @RequestBody UserDTO userDTO) {

        User user = new User();
        user.setPassword(userDTO.getPassword());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setId(id);
        boolean result = userService.updateById(user);
        if (result) {
            return "用户更新成功";
        }else
            return "用户更新失败";

    }

    //根据id删除用户
    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Integer id) {
        boolean result = userService.removeById(id);
        if (result) {
            return "用户成功删除";
        }else {
            return "未找到用户";
        }
    }

    //根据用户名删除用户
    @DeleteMapping("/deleteByUsername")
    public String deleteByUsername(@RequestParam String username) {
        boolean result = userService.deleteByUsername(username);
        if (result) {
            return "用户删除成功";
        }else {
            return "用户名错误或用户不存在";
        }
    }

    //只更改用户密码
    @PatchMapping("/updatePassword/{id}")
    public String updatePassword(@PathVariable Integer id,@Validated @RequestParam String password) {
        User user = userService.findById(id);
        if (user == null) {
            return "用户不存在";
        }
        if (!password.equals(user.getPassword())) {
            userService.updatePassword(id,password);
            return "密码修改成功";
        }
        return "新旧密码不能重复";
    }

}
