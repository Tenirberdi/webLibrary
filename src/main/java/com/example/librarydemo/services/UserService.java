package com.example.librarydemo.services;

import com.example.librarydemo.models.Role;
import com.example.librarydemo.models.User;
import com.example.librarydemo.repository.RoleRepository;
import com.example.librarydemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository UserRepository;

    @Autowired
    private RoleRepository roleRepository;


    public List<User> UserList(){
        return (List<User>)UserRepository.findAll();
    }

    public List<User> getStudents(){
        return UserRepository.getStudentList();
    }

    public void creatAdmin(User admin){
        admin.setEnabled(true);
        admin.setRoleId(roleRepository.findById(3).get());
        UserRepository.save(admin);
    }

    public void creatLibrarian(User librarian){
        librarian.setEnabled(true);
        librarian.setRoleId(roleRepository.findById(2).get());
        UserRepository.save(librarian);
    }

    public void creatStudent(User student){
        student.setEnabled(true);
        student.setRoleId(roleRepository.findById(1).get());
        UserRepository.save(student);
    }

    public User findUserById(int id){
        return UserRepository.findById(id).get();
    }
    public void deleteUser(int id){
        UserRepository.deleteById(id);
    }
}
