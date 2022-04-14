package com.example.librarydemo.repository;

import com.example.librarydemo.DTO.TakenBooks;
import com.example.librarydemo.DTO.TakenBooksForLibrarian;
import com.example.librarydemo.DTO.TakenBooksHistory;
import com.example.librarydemo.models.Taken;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TakenRepository extends CrudRepository<Taken, Long> {

    @Query(value = "select t.id as id, t.book_id as book_id, b.name as book_name, b.author as book_author, t.start_date as start_date from taken t join book b on t.book_id = b.id where t.student_id = ? and t.end_date IS NULL" , nativeQuery = true)
    List<TakenBooks> getTakenBooks(long student_id);

    @Query(value = "select t.id as id, t.book_id as book_id, b.name as book_name, b.author as book_author, t.start_date as start_date, t.end_date as end_date from taken t join book b on t.book_id = b.id where t.student_id = ? and t.end_date IS NOT NULL" , nativeQuery = true)
    List<TakenBooksHistory> getTakenBooksHistory(long student_id);

    @Query(value = "select t.id as id, t.book_id as book_id, t.student_id, b.name as book_name, b.author as book_author, t.start_date as start_date from taken t join book b on t.book_id = b.id where t.end_date IS NULL" , nativeQuery = true)
    List<TakenBooksForLibrarian> getTakenBooksForLibrarian();


}
