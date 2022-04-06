package com.example.librarydemo.models;

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
    private Long id;
    private String fullName;
    private String phoneNumber;
    private String studentGroup;
    private String login;
    private String password;
    private boolean enabled;

    @OneToMany(mappedBy = "user")
    private List<Taken> takenBooks;

    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role_id;

}
