package com.example.librarydemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String group;
    private String address;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="student_id")
    private User studentId;
}
