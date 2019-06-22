package com.leejung.web.mapper;

import java.util.List;

import com.leejung.web.domain.UserDTO;

import org.springframework.stereotype.Repository;

/**
 * UserMapper
 */
@Repository
public interface UserMapper {
    public void addUser(UserDTO User);
    public List<UserDTO> selectUser(UserDTO User);
    public List<UserDTO> selectUserByOption(UserDTO User);
    public UserDTO selectUserByUserId(UserDTO User);
    public void updateUser(UserDTO User);
    public void deleteUser(UserDTO User);
    public UserDTO login(UserDTO User);

    
}