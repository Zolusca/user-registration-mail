package com.vonsan.id.Service;

import com.vonsan.id.DTO.UserResponse;
import com.vonsan.id.Entity.User;

import javax.jws.soap.SOAPBinding;

public interface UserService {
    UserResponse insert(User user);
}
