package com.example.librarydemo.repository;

import com.example.librarydemo.DTO.StudentsDTO;
import com.example.librarydemo.models.Student;
import com.example.librarydemo.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "select u.*, s.address, s.grop from usr as u join role as r on u.role_id = r.id JOIN `student` as s on u.id = s.student_id where r.role = 'ROLE_STUDENT'" , nativeQuery = true)
    List<StudentsDTO> getStudentList();

    @Query(value = "select * from usr as u where u.full_name = ? " , nativeQuery = true)
    User getStudent(String fullName);



    @Query(value = "SELECT * FROM `usr` WHERE `id` = ? and role_id = 1" , nativeQuery = true)
    User getStudentById(int id);

}
