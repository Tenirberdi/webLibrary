package com.example.librarydemo.DTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import java.sql.Date;

public interface TakenBooksHistory {

    long getId();
    long getBookId();
    String getBookName();
    String getBookAuthor();
    Date getStartDate();
    Date getEndDate();
    String librarianName();
}
