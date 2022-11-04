package com.example.springboot.NoleggioAutoSpringBoot.dto;

import java.time.LocalDate;
import java.util.Set;

public class UtenteDto {

    private Long id;

    private String nome;

    private String cognome;

    private LocalDate dataNascita;

    private String username;

    private String password;

    private boolean admin;

    private String email;

    private Set<PrenotazioneDto> prenotazioni;
}
