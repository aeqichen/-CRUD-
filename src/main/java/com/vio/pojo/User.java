package com.vio.pojo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class User {

    private Integer id;
    private String username;
    @JsonIgnore
    private String password;
    @Email
    private String email;

}
