package com.example.librarydemo.services;

import com.example.librarydemo.JavaModels.TakenBooks;
import com.example.librarydemo.JavaModels.TakenBooksHistory;
import com.example.librarydemo.models.Taken;
import com.example.librarydemo.repository.TakenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TakenService {

    @Autowired
    TakenRepository takenRepository;

    public List<TakenBooks> getTakenList(long student_id){
        List<TakenBooks> takenList = (List<TakenBooks>) takenRepository.getTakenBooks(student_id);
        return takenList;
    }

    public List<TakenBooksHistory> getTakenBooksHistory(long student_id){
        List<TakenBooksHistory> booksHistories = (List<TakenBooksHistory>) takenRepository.getTakenBooksHistory(student_id);
        return booksHistories;
    }
}
