package com.example.librarydemo.repository;

import com.example.librarydemo.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "select u.* from usr as u join role as r on u.role_id = r.id where r.role = 'ROLE_STUDENT'" , nativeQuery = true)
    List<User> getStudentList();

}
