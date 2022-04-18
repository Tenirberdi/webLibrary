package com.example.librarydemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="statistic_book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatisticBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int takenQuantity;

    @ManyToOne
    private Book bookId;
}
