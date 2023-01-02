package com.project.projectakhir.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@Table(name = "users")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "password")
    @NotBlank(message = "password doesnt blank")
    private String password;

    @Column(name = "poin")
    private int poin;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Transaction> transactions;
}
