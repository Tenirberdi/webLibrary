package com.example.librarydemo.repository;

import com.example.librarydemo.models.Category;
import com.example.librarydemo.models.Student;
import com.example.librarydemo.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    @Query(value = "SELECT * FROM `student` WHERE `student_id` = ?" , nativeQuery = true)
    Student getStudentById(int studentId);


}
