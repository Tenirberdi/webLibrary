package com.example.librarydemo.DTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import java.sql.Date;

public interface TakenBooksHistory {

    long getId();
    long getBook_id();
    String getBook_name();
    String getBook_author();
    Date getStart_date();
    Date getEnd_date();
}
