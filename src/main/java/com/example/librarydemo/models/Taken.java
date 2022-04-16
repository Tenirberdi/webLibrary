package com.example.librarydemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private int id;
    private Date startDate;
    private Date endDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="student_id")
    private User studentId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="book_id")
    private Book book;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="librarian_id")
    private User librarianId;

}
