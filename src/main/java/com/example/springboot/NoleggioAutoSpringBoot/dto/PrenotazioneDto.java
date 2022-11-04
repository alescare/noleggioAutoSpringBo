package com.example.springboot.NoleggioAutoSpringBoot.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class PrenotazioneDto {

    private Long id;

    private LocalDate dataInizio;

    private LocalDate dataFine;

    private boolean approvata;

    private UtenteDto utente;

    private AutoDto auto;
}
