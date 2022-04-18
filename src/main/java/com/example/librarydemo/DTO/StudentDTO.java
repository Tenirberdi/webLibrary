package com.example.librarydemo.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    int id;
    String email;
    String fullName;
    String login;
    String password;
    String phone;
    String role;
    String group;
    String address;
}
