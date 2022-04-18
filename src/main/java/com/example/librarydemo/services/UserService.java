package com.example.librarydemo.services;

import com.example.librarydemo.DTO.BookDTO;
import com.example.librarydemo.DTO.StudentDTO;
import com.example.librarydemo.DTO.StudentsDTO;
import com.example.librarydemo.models.*;
import com.example.librarydemo.repository.RoleRepository;
import com.example.librarydemo.repository.StudentRepository;
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

    @Autowired
    private StudentRepository studentRepository;


    public List<User> UserList(){
        return (List<User>)UserRepository.findAll();
    }

    public List<StudentsDTO> getStudents(){
        return UserRepository.getStudentList();
    }

    public void addStudent(Student student){
        studentRepository.save(student);
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

    public StudentDTO getStudent(int id){
        User user = UserRepository.getStudentById(id);

        System.out.println(user.getId());
        Student student = studentRepository.getStudentById(user.getId());

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setId(user.getId());
        studentDTO.setEmail(user.getEmail());
        studentDTO.setAddress(student.getAddress());
        studentDTO.setGroup(student.getGrop());
        studentDTO.setLogin(user.getLogin());
        studentDTO.setPassword(user.getPassword());
        studentDTO.setPhone(user.getPhoneNumber());
        studentDTO.setFullName(user.getFullName());

        return studentDTO;
    }

    public void editStudent(StudentDTO studentDTO){


        User user = UserRepository.getStudentById(studentDTO.getId());

        user.setEmail(studentDTO.getEmail());
        user.setFullName(studentDTO.getFullName());
        user.setLogin(studentDTO.getLogin());
        user.setPassword(studentDTO.getPassword());
        user.setPhoneNumber(studentDTO.getPhone());

        UserRepository.save(user);

        Student student = studentRepository.getStudentById(user.getId());

        student.setAddress(studentDTO.getAddress());
        student.setGrop(studentDTO.getGroup());

        studentRepository.save(student);


    }
}
