package com.example.librarydemo.JavaModels;

import java.sql.Date;


import javax.persistence.*;
import java.sql.Date;

@Entity
@NamedNativeQuery(
        name = "findTakenBooks",
        query =
                "select t.id as id, t.book_id as book_id, b.name as book_name, b.author as book_author, t.start_date as start_date from taken t join book b on t.book_id = b.id where t.student_id = ? and t.end_date IS NULL",
        resultClass = TakenBooks.class
)
public class TakenBooks {

    @Id
    private long id;
    private long book_id;
    private String book_name;
    private String book_author;
    private Date start_date;

    public TakenBooks() {
    }

    public TakenBooks(long id, long book_id, String book_name, String book_author, Date start_date) {
        this.id = id;
        this.book_id = book_id;
        this.book_name = book_name;
        this.book_author = book_author;
        this.start_date = start_date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }
}
