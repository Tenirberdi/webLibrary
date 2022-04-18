package com.example.librarydemo.repository;

import com.example.librarydemo.models.EBook;
import org.springframework.data.repository.CrudRepository;

public interface EBookRepository extends CrudRepository<EBook, Integer> {
}
