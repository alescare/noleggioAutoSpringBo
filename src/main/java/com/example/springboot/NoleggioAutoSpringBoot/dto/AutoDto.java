package com.example.springboot.NoleggioAutoSpringBoot.dto;

import lombok.Data;

import java.util.Set;

@Data
public class AutoDto {

    private Long id;

    private String targa;

    private String costruttore;

    private String modello;

    private Integer annoImmatricolazione;

    private String tipologia;

    private Set<PrenotazioneDto> prenotazioni;
}
