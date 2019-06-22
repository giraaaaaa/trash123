package com.leejung.web.service;

import java.util.List;

import com.leejung.web.domain.UserDTO;

import org.springframework.stereotype.Component;

/**
 * UserService
 */
@Component
public interface userService {
    public void addUser(UserDTO User);
    public List<UserDTO> selectUser(UserDTO User);
    public List<UserDTO> selectUserByOption(UserDTO User);
    public UserDTO selectUserByUserId(UserDTO User);
    public void updateUser(UserDTO User);
    public void deleteUser(UserDTO User);
    public int countAll();
    public UserDTO user(UserDTO user);

    
}