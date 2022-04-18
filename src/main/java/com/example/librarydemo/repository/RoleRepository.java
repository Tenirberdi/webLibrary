package com.example.librarydemo.repository;

import com.example.librarydemo.models.Category;
import com.example.librarydemo.models.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {

    @Query(value = "SELECT * FROM `role` WHERE `role` = ?;", nativeQuery = true)
    Role getRoleByName(String name);

}
