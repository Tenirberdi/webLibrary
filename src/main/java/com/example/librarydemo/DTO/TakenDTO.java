package com.example.librarydemo.DTO;

import java.sql.Date;

public class TakenDTO {
    private Date start_date;
    private Date end_date;
    private long student_id;
    private long book_id;

    public TakenDTO() {
    }

    public TakenDTO(Date start_date, Date end_date, long student_id, long book_id) {
        this.start_date = start_date;
        this.end_date = end_date;
        this.student_id = student_id;
        this.book_id = book_id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }
}
