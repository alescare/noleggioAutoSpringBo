package com.example.springboot.NoleggioAutoSpringBoot.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "prenotazione")
@Data
public class Prenotazione implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "data_inizio")
    @Past(message = "{Past.Prenotazione.dataInizio.validation}")
    private LocalDate dataInizio;

    @Column(name = "data_fine")
    @Past(message = "{Past.Prenotazione.dataFine.validation}")
    private LocalDate dataFine;

    @ManyToOne
    @JoinColumn(name = "utente")
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private Utente utente;

    @Column(name = "approvata")
    private boolean approvata;


    @ManyToOne
    @JoinColumn(name = "auto", nullable = true)
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private Auto auto;

}
