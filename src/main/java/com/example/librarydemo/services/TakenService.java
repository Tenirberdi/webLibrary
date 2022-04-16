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


    public List<TakenBooks> getTakenList(int student_id){
        List<TakenBooks> takenList = (List<TakenBooks>) takenRepository.getTakenBooks(student_id);
        return takenList;
    }

    public List<TakenBooksHistory> getTakenBooksHistory(int student_id){
        List<TakenBooksHistory> booksHistories = (List<TakenBooksHistory>) takenRepository.getTakenBooksHistory(student_id);
        return booksHistories;
    }

    public List<TakenBooksForLibrarian> getTakenBooksForLibrarian(){
        return takenRepository.getTakenBooksForLibrarian();
    }

    public int giveBook(TakenDTO book) throws ParseException, CustomException {

        int bookId;
        int studentId;

        try {
            studentId = Integer.parseInt(book.getStudentInfo());
        } catch (NumberFormatException nfe) {
            studentId =  userRepository.getStudent(book.getStudentInfo()).getId();
        }

        try {
            bookId = Integer.parseInt(book.getBookInfo());
        } catch (NumberFormatException nfe) {
            bookId =  userRepository.getStudent(book.getStudentInfo()).getId();
        }


        if(bookRepository.findById(bookId).get() == null){
            return 404;
        }
        if(userRepository.findById(studentId).get() == null){
            return 404;
        }

        Book b = bookRepository.findById(bookId).get();
        User u = userRepository.findById(studentId).get();

        if(!(b.isInLibrary())){
            return 404;
        }
        b.setInLibrary(false);

        bookRepository.save(b);

        book.setStartDate(CommonFunc.getCurrentDate());

        Taken taken = new Taken();
        taken.setStartDate(book.getStartDate());
        taken.setStudentId(u);
        taken.setBook(b);
        takenRepository.save(taken);

        return 200;
    }
}
