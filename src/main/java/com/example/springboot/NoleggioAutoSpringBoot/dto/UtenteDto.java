package com.example.springboot.NoleggioAutoSpringBoot.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UtenteDto {

    private Long id;

    private String nome;

    private String cognome;

    private LocalDate dataNascita;

    private String username;

    private String password;

    private boolean admin;

    private String email;


}
