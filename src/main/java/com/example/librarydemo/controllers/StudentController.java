package com.example.librarydemo.controllers;

import com.example.librarydemo.JavaModels.TakenBooks;
import com.example.librarydemo.JavaModels.TakenBooksHistory;
import com.example.librarydemo.services.TakenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class StudentController {
    @Autowired
    private TakenService takenService;

    @GetMapping("/student/takenBooks")
    public ResponseEntity<List<TakenBooks>> getTakenBooks(){
        return ResponseEntity.ok(takenService.getTakenList(1));
    }

    @GetMapping("/student/takenBooksHistory")
    public ResponseEntity<List<TakenBooksHistory>> getTakenBooksHistory(){
        return ResponseEntity.ok(takenService.getTakenBooksHistory(1));
    }




}
