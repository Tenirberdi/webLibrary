package com.example.librarydemo.DTO;

import java.sql.Date;


public interface TakenBooks {
    long getId();
    long getBook_id();
    String getBook_name();
    String getBook_author();
    Date getStart_date();

}
