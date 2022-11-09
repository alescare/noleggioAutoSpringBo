package com.example.springboot.NoleggioAutoSpringBoot.dto;

import lombok.Data;

@Data
public class AutoDto {

    private Long id;

    private String targa;

    private String costruttore;

    private String modello;

    private Integer annoImmatricolazione;

    private String tipologia;


}
