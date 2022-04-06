package com.example.librarydemo.repository;

import com.example.librarydemo.JavaModels.TakenBooks;
import com.example.librarydemo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query(name = "Select u.id as id, u.fullName as fullName, u.phoneNumber as phoneNumber, u.studentGroup as studentGroup, u.login as login, u.password as password, u.enabled as enabled from usr u join role r on u.role_id = r.id where r.role = 'ROLE_STUDENT'" , nativeQuery = true)
    List<User> getStudentList();

}
