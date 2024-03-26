package com.vonsan.id.Service;

import com.vonsan.id.DTO.UserResponse;
import com.vonsan.id.DTO.UserResponseMapper;
import com.vonsan.id.Entity.User;
import com.vonsan.id.Repository.UserRepository;
import com.vonsan.id.Util.StringOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImpl extends UserServices{
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserResponse insert(User user) {
        // cek email apakah sudah ada
        if(userRepository
                .findByEmail(user.getEmail())
                .isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Email telah terdaftar");
        }

        // ubah nama user menjadi first capital letter
        user.setName(
                StringOperation
                        .capitalizeString(user.getName()," ")
            );

        // simpan user
        userRepository.save(user);

        // register email
        emailRegisterUser(user);

        return new UserResponseMapper().apply(user);
    }
}
