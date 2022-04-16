package com.example.librarydemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="usr")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;
    private String phoneNumber;
    private String login;
    private String password;
    private boolean enabled;
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "studentId")
    private List<Taken> takenBooks;

    @JsonIgnore
    @OneToMany(mappedBy = "studentId")
    private List<Student> student;

    @JsonIgnore
    @OneToMany(mappedBy = "librarianId")
    private List<Taken> takenBooks1;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="role_id")
    private Role roleId;

}
