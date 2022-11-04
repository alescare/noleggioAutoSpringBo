package com.example.springboot.NoleggioAutoSpringBoot.service;

import com.example.springboot.NoleggioAutoSpringBoot.entity.Prenotazione;
import com.example.springboot.NoleggioAutoSpringBoot.entity.Utente;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public interface PrenotazioneService {

    public void salvaOAggiornaPrenotazione(Prenotazione prenotazione);

    public Iterable<Prenotazione> getPrenotazioni();

    public Optional<Prenotazione> getPrenotazione(Long id);

    public List<Prenotazione> getPrenotazioniDaApprovare();

    public List<Prenotazione> getPrenotazioniUtente(Utente utente);

    public boolean prenotazioneInCorsoUtente(Utente utente);

    public void cancellaPrenotazione(Prenotazione prenotazione);


    public List<Prenotazione> getListaPrenotazioniNelPeriodo(LocalDate dataInizioPeriodo, LocalDate dataFinePeriodo);
}
