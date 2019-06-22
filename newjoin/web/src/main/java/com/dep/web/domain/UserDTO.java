package com.dep.web.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * UserDTO
 */
@Data@Component@Lazy
public class UserDTO {
    private String userid,
                    password,
                    phone,
                    address;
    
}

