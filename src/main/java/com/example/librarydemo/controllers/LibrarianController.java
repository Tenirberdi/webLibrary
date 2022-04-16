package com.example.librarydemo.controllers;


import com.example.librarydemo.Exceptions.CustomException;
import com.example.librarydemo.DTO.TakenBooksForLibrarian;
import com.example.librarydemo.DTO.TakenDTO;
import com.example.librarydemo.models.Book;
import com.example.librarydemo.models.User;
import com.example.librarydemo.services.BookService;
import com.example.librarydemo.services.TakenService;
import com.example.librarydemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/librarian")
public class LibrarianController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @Autowired
    private TakenService takenService;



    @PostMapping("/addBook")
    public ResponseEntity addBook(@RequestBody Book book){
        System.out.println("Adding Book");
        bookService.creatBook(book);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/book/{book_id}")
    public ResponseEntity<Book> getBook(@PathVariable("book_id") int id){

        Book book = bookService.findBookById(id);

        return ResponseEntity.ok(book);
    }

    @PostMapping("/addStudent")
    public ResponseEntity addStudent(@RequestBody User student){
        userService.creatStudent(student);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(){
        return ResponseEntity.ok(bookService.BookList());
    }

    @GetMapping("/taken")
    public ResponseEntity<List<TakenBooksForLibrarian>> getTakenBooks(){
        return ResponseEntity.ok(takenService.getTakenBooksForLibrarian());
    }

    @PostMapping("/giveBook")
    public ResponseEntity giveBook(@RequestBody TakenDTO book) throws ParseException, CustomException {
        int code = takenService.giveBook(book);

        if(code == 404){
            return (ResponseEntity) ResponseEntity.notFound();
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/students")
    public ResponseEntity<List<User>> getStudents(){
        return ResponseEntity.ok(userService.getStudents());
    }










}
