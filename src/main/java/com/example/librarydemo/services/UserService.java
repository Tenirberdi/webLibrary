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

    public UserService(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    public List<User> UserList(){
        return (List<User>)UserRepository.findAll();
    }

    public List<User> getStudents(){
        return UserRepository.getStudentList();
    }

    public void creatAdmin(User admin){
        admin.setEnabled(true);
        admin.setRole_id(roleRepository.findById(3L).get());
        UserRepository.save(admin);
    }

    public void creatLibrarian(User librarian){
        librarian.setEnabled(true);
        librarian.setRole_id(roleRepository.findById(2L).get());
        UserRepository.save(librarian);
    }

    public void creatStudent(User student){
        student.setEnabled(true);
        student.setRole_id(roleRepository.findById(1L).get());
        UserRepository.save(student);
    }

    public User findUserById(Long id){
        return UserRepository.findById(id).get();
    }
    public void deleteUser(Long id){
        UserRepository.deleteById(id);
    }
}
