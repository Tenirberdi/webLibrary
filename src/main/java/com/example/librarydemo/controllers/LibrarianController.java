package com.example.librarydemo.controllers;


import com.example.librarydemo.JavaModels.TakenBooks;
import com.example.librarydemo.JavaModels.TakenBooksHistory;
import com.example.librarydemo.models.Book;
import com.example.librarydemo.services.BookService;
import com.example.librarydemo.services.TakenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/librarian")
public class LibrarianController {

    @Autowired
    private BookService bookService;

    @GetMapping("/addBook")
    public ResponseEntity addBook(@RequestBody Book book){

        bookService.creatBook(book);
        return ResponseEntity.ok(HttpStatus.OK);
    }


//    @GetMapping("/checkAddBook")
//    public ResponseEntity<Book> sendBook(){
////        Book book = new Book(111111L, "Will","Will Smith");
//    }
}
