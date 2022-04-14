package com.example.librarydemo.services;

import com.example.librarydemo.Exceptions.CustomException;
import com.example.librarydemo.DTO.*;
import com.example.librarydemo.models.Book;
import com.example.librarydemo.models.Taken;
import com.example.librarydemo.models.User;
import com.example.librarydemo.repository.BookRepository;
import com.example.librarydemo.repository.TakenRepository;
import com.example.librarydemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class TakenService {

    @Autowired
    TakenRepository takenRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;


    public List<TakenBooks> getTakenList(long student_id){
        List<TakenBooks> takenList = (List<TakenBooks>) takenRepository.getTakenBooks(student_id);
        return takenList;
    }

    public List<TakenBooksHistory> getTakenBooksHistory(long student_id){
        List<TakenBooksHistory> booksHistories = (List<TakenBooksHistory>) takenRepository.getTakenBooksHistory(student_id);
        return booksHistories;
    }

    public List<TakenBooksForLibrarian> getTakenBooksForLibrarian(){
        return takenRepository.getTakenBooksForLibrarian();
    }

    public void giveBook(TakenDTO book) throws ParseException, CustomException {

        Book b = bookRepository.findById(book.getBook_id()).get();
        User u = userRepository.findById(book.getStudent_id()).get();

        if(!(b.isInLibrary())){
            throw new CustomException("The book is already taken");
        }
        b.setInLibrary(false);

        bookRepository.save(b);

        book.setStart_date(CommonFunc.getCurrentDate());

        Taken taken = new Taken();
        taken.setStart_date(book.getStart_date());
        taken.setUser(u);
        taken.setBook(b);
        takenRepository.save(taken);

    }
}
