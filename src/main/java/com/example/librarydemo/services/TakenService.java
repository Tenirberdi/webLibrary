package com.example.librarydemo.services;

import com.example.librarydemo.JavaModels.CommonFunc;
import com.example.librarydemo.JavaModels.TakenBooks;
import com.example.librarydemo.JavaModels.TakenBooksForLibrarian;
import com.example.librarydemo.JavaModels.TakenBooksHistory;
import com.example.librarydemo.models.Book;
import com.example.librarydemo.models.Taken;
import com.example.librarydemo.repository.BookRepository;
import com.example.librarydemo.repository.TakenRepository;
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

    public void giveBook(Taken book) throws ParseException {
        Book b = bookRepository.findById(book.getBook().getId()).get();

        b.setInLibrary(false);

        bookRepository.save(b);

        book.setStart_date(CommonFunc.getCurrentDate());

        takenRepository.save(book);

    }
}
