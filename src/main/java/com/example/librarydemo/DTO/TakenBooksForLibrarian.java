package com.example.librarydemo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import java.sql.Date;



public interface TakenBooksForLibrarian {
    long getId();
    long getBook_id();
    String getBook_name();
    String getBook_author();
    Date getStart_date();
    long getStudent_id();

}
