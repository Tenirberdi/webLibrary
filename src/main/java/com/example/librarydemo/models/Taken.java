package com.example.librarydemo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name="taken")
@AllArgsConstructor
@NoArgsConstructor
public class Taken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date start_date;
    private Date end_date;

    @ManyToOne
    @JoinColumn(name="student_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="book_id")
    private Book book;

}
