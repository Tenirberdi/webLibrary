package com.example.librarydemo.services;

import com.example.librarydemo.models.Book;
import com.example.librarydemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
//    private final BookRepository bookRepository;
//    public BookService(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }

    public List<Book> BookList(){
        return (List<Book>)bookRepository.findAll();
    }

    public void creatBook(Book Book){
        bookRepository.save(Book);
    }

    public Book findBookById(Long id){
        return bookRepository.findById(id).get();
    }
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
}
