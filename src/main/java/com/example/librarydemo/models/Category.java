package com.example.librarydemo.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String category;

    @OneToMany(mappedBy = "category")
    private List<Book> books;

    @OneToMany(mappedBy = "category")
    private List<EBook> books1;

}
