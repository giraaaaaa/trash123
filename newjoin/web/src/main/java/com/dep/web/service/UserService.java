package com.dep.web.service;

import com.dep.web.domain.UserDTO;

import org.springframework.stereotype.Component;

/**
 * UserService
 */
@Component
public interface UserService {
    public void addUser(UserDTO User);
    public void updateUser(UserDTO User);
    public void deleteUser(UserDTO User);
    public UserDTO login(UserDTO User);

    
}