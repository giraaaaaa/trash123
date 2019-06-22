package com.dep.web.mapper;

import com.dep.web.domain.UserDTO;

import org.springframework.stereotype.Repository;

/**
 * UserMapper
 */
@Repository
public interface UserMapper {
    public void addUser(UserDTO User);
    public void updateUser(UserDTO User);
    public void deleteUser(UserDTO User);
    public UserDTO login(UserDTO User);

}