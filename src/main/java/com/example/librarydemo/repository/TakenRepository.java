package com.example.librarydemo.repository;

import com.example.librarydemo.JavaModels.TakenBooks;
import com.example.librarydemo.JavaModels.TakenBooksForLibrarian;
import com.example.librarydemo.JavaModels.TakenBooksHistory;
import com.example.librarydemo.models.Taken;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TakenRepository extends CrudRepository<Taken, Long> {

    @Query(name = "findTakenBooks" , nativeQuery = true)
    List<TakenBooks> getTakenBooks(long student_id);

    @Query(name = "findTakenBooksHistory" , nativeQuery = true)
    List<TakenBooksHistory> getTakenBooksHistory(long student_id);

    @Query(name = "findTakenBooksForLibrarian" , nativeQuery = true)
    List<TakenBooksForLibrarian> getTakenBooksForLibrarian();


}
