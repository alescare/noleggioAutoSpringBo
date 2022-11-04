package com.example.springboot.NoleggioAutoSpringBoot.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "utente")
@Data
public class Utente implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "{NotEmpty.Utente.nome.validation}")
    @Column(name = "nome")
    private String nome;

    @NotEmpty(message = "{NotEmpty.Utente.cognome.validation}")
    @Column(name = "cognome")
    private String cognome;

    @Column(name = "data_nascita")
    @NotNull(message = "{NotEmpty.Utente.dataNascita.validation}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascita;

    @NotEmpty(message = "{NotEmpty.Utente.username.validation}")
    @Column(name = "username", unique = true)
    private String username;

    @NotEmpty(message = "{NotEmpty.Utente.password.validation}")
    @Column(name = "password")
    private String password;

    @Column(name = "admin")
    private boolean admin;

    @Email(message = "{Email.Utente.email.validation}")
    @NotEmpty(message = "{NotEmpty.Utente.email.validation}")
    @Column(name = "email")
    private String email;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE,  mappedBy = "utente", orphanRemoval = true)
    @JsonManagedReference
    private Set<Prenotazione> prenotazioni;
}
