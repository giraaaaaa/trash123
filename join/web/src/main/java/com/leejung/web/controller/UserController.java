package com.leejung.web.controller;


import com.leejung.web.domain.UserDTO;
import com.leejung.web.service.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 */
@RestController
@RequestMapping("/")
public class UserController {
    @Autowired userService userService;
    @Autowired UserDTO user;
    // @RequestMapping("/login")
    // public @ResponseBody UserDTO login(@PathVariable("userId")String id,
    //                     @PathVariable("password")String pass){
    //     System.out.println("로그인 성공");
    //     return userService.login(user);
    // }
    @PostMapping("/users")
    public void join(@RequestBody UserDTO param){
        System.out.println("데이터도착 : " + param.getUserId());
        user.setUserId(param.getUserId());
        user.setPassword(param.getPassword());
        user.setPhone(param.getPhone());
        user.setAddress(param.getAddress());
        userService.addUser(user);
    }
}