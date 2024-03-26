package com.vonsan.id.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotBlank
    @Size(max = 50,message = "username length cant over 50")
    private String username;

    @NotBlank
    @Size(max = 100,message = "name length cant over 100")
    private String name;

    @NotBlank
    @Size(max = 50,message = "password length cant over 50")
    private String password;

    @Email
    @NotBlank
    @Size(max = 50,message = "email length cant over 50")
    private String email;
}
