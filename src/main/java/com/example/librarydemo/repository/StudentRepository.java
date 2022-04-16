package com.example.librarydemo.repository;

import com.example.librarydemo.models.Student;
import com.example.librarydemo.models.User;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
