package com.vonsan.id.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vonsan.id.DTO.UserRequest;
import com.vonsan.id.DTO.UserResponse;
import com.vonsan.id.Entity.User;
import com.vonsan.id.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> addUser(@Valid @RequestBody UserRequest userRequest){
        // mapping data
        User user = objectMapper.convertValue(userRequest,User.class);
        // inserting data
        UserResponse userResponse = userService.insert(user);
        // return response
        return new ResponseEntity<>(userResponse,HttpStatus.CREATED);
    }
}
