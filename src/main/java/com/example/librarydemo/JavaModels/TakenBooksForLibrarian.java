package com.example.librarydemo.JavaModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import java.sql.Date;


@Entity
@NamedNativeQuery(
        name = "findTakenBooksForLibrarian",
        query = "select t.id as id, t.book_id as book_id, t.student_id, b.name as book_name, b.author " +
                "as book_author, t.start_date as start_date from taken t join book b on " +
                "t.book_id = b.id where t.end_date IS NULL",
        resultClass = TakenBooksForLibrarian.class
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TakenBooksForLibrarian {

    @Id
    private long id;
    private long book_id;
    private String book_name;
    private String book_author;
    private Date start_date;
    private long student_id;

}
