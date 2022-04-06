package com.example.librarydemo.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;
    private boolean inLibrary;

    @OneToMany(mappedBy = "book")
    private List<Taken> takenBooks;
}
//
//    public void Book(long id, String name , String author){
//        this.id = id;
//        this.name = name;
//        this.author = author;
//        this.inLibrary = true;
//    }
//}
