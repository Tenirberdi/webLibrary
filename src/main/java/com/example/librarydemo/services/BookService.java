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


    public List<Book> BookList(){
        return (List<Book>)bookRepository.findAll();
    }

    public List<Book> InLibraryBookList(){
        return (List<Book>)bookRepository.getInLibraryBooks();
    }


    public void creatBook(Book book){
        book.setInLibrary(true);
        bookRepository.save(book);
    }


    public Book findBookById(int id){
        return bookRepository.findById(id).get();
    }
    public void deleteBook(int id){
        bookRepository.deleteById(id);
    }


}
