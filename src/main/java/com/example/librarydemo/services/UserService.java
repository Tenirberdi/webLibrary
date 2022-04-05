package com.example.librarydemo.services;

import com.example.librarydemo.models.User;
import com.example.librarydemo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository UserRepository;
    public UserService(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    public List<User> UserList(){
        return (List<User>)UserRepository.findAll();
    }
    public void creatUser(User User){
        UserRepository.save(User);
    }
    public User findUserById(Long id){
        return UserRepository.findById(id).get();

    }
    public void deleteUser(Long id){
        UserRepository.deleteById(id);
    }
}
