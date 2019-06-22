package com.dep.web.controller;

import java.util.HashMap;

import com.dep.web.domain.UserDTO;
import com.dep.web.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired UserService UserService;
    @Autowired UserDTO user;
    @GetMapping("/{userid}/{password}")
    public UserDTO login(@PathVariable("userid")String id,
                        @PathVariable("password")String pass){
        System.out.println("도착");
        System.out.println(id);
        System.out.println(pass);
        user.setUserid(id);
        user.setPassword(pass);
                
        return UserService.login(user);
    }


    @PostMapping("")
    public UserDTO join(@RequestBody UserDTO param) {
        System.out.println("가입성공 : " + param);
        System.out.println(param.getUserid());

            user.setUserid(param.getUserid());
            user.setPassword(param.getPassword());
            user.setPhone(param.getPhone());
            user.setAddress(param.getAddress());
            UserService.addUser(user); 
        return user;

    }
    @PutMapping("/{userid}")
    public HashMap<String,Object> update(@RequestBody UserDTO param) {
 
             System.out.println("=====post mapping======");
             user.setUserid(param.getUserid());
             user.setPassword(param.getPassword());
             user.setPhone(param.getPhone());
             user.setAddress(param.getAddress());
             UserService.updateUser(user);
             HashMap<String,Object> map = new HashMap<>();
             map.put("result", "SUCCESS");
         return map;   
     }
     @DeleteMapping("/{userid}")
     public HashMap<String,Object> delete(@PathVariable("userid") String userid) {
          user.setUserid(userid);
          UserService.deleteUser(user);
          HashMap<String,Object> map = new HashMap<>();
  
      return map;
     }
    
}