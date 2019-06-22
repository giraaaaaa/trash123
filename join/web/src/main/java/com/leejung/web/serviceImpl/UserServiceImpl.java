package com.leejung.web.serviceImpl;

import java.util.List;

import com.leejung.web.domain.UserDTO;
import com.leejung.web.service.userService;

import org.springframework.stereotype.Service;

/**
 * UserServiceImpl
 */
@Service
public class UserServiceImpl implements userService {

    @Override
    public void addUser(UserDTO User) {

    }

    @Override
    public List<UserDTO> selectUser(UserDTO User) {
        return null;
    }

    @Override
    public List<UserDTO> selectUserByOption(UserDTO User) {
        return null;
    }

    @Override
    public UserDTO selectUserByUserId(UserDTO User) {
        return null;
    }

    @Override
    public void updateUser(UserDTO User) {

    }

    @Override
    public void deleteUser(UserDTO User) {

    }

    @Override
    public int countAll() {
        return 0;
    }

    @Override
    public UserDTO user(UserDTO user) {
        return null;
    }

    
}