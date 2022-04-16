package com.example.librarydemo.repository;

import com.example.librarydemo.models.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {
}
