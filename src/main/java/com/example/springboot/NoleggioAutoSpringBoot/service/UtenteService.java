package com.example.springboot.NoleggioAutoSpringBoot.service;

import com.example.springboot.NoleggioAutoSpringBoot.dto.UtenteDto;

import java.util.List;


public interface UtenteService {

     void salvaOAggiornaUtente(UtenteDto utenteDto);

     UtenteDto cercaUtentePerUsername(String username);


     List<UtenteDto> listaUtenti();


     UtenteDto cercaUtentePerId(Long id);


     void cancellaUtentePerId(Long id);
}
