package com.dep.web.serviceImpl;

import com.dep.web.domain.UserDTO;
import com.dep.web.mapper.UserMapper;
import com.dep.web.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired UserMapper UserMapper;
    @Override
    public void addUser(UserDTO User) {
        System.out.println(User);
        UserMapper.addUser(User);
    }


    @Override
    public void updateUser(UserDTO User) {
        UserMapper.updateUser(User);

    }

    @Override
    public void deleteUser(UserDTO User) {
        UserMapper.deleteUser(User);
    }

    @Override
    public UserDTO login(UserDTO User) {
        return UserMapper.login(User);
    }

    
}