package com.vonsan.id.DTO;

import com.vonsan.id.Entity.User;

import java.util.function.Function;

public class UserResponseMapper implements Function<User,UserResponse> {
    @Override
    public UserResponse apply(User user) {
        return new UserResponse
                (
                        user.getUsername(),
                        user.getName(),
                        user.getEmail()
                );
    }
}
