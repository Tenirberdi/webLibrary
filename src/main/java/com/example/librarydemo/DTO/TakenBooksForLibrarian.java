package com.example.librarydemo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import java.sql.Date;



public interface TakenBooksForLibrarian {
    int getId();
    int getBookId();
    String getBookName();
    String getBookAuthor();
    Date getStartDate();
    int getStudentId();
    String getStudentName();
    String getLibrarianName();

}
