package com.example.springboot.NoleggioAutoSpringBoot.service;

import com.example.springboot.NoleggioAutoSpringBoot.dto.PrenotazioneDto;

import java.time.LocalDate;
import java.util.List;


public interface PrenotazioneService {

     void salvaOAggiornaPrenotazione(PrenotazioneDto prenotazioneDto);

     List<PrenotazioneDto> listaPrenotazioni();

     List<PrenotazioneDto> prenotazioniDaApprovare();

     List<PrenotazioneDto> prenotazioniUtente(Long Idutente);

     boolean prenotazioneInCorsoUtente(Long idUtente);


    void cancellaPrenotazionePerId(Long id);

    List<Long> getListaIdAutoOccupate(LocalDate dataInizio, LocalDate dataFine);
}
