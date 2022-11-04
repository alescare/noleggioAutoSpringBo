package com.example.springboot.NoleggioAutoSpringBoot.repository;

import com.example.springboot.NoleggioAutoSpringBoot.entity.Prenotazione;
import com.example.springboot.NoleggioAutoSpringBoot.entity.Utente;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends CrudRepository<Prenotazione, Long> {
    
    public List<Prenotazione> getPrenotazioniDaApprovare();

    public List<Prenotazione> getPrenotazioniUtente(Utente utente);

    public boolean prenotazioneInCorsoUtente(Utente utente);

    public List<Prenotazione> getListaPrenotazioniNelPeriodo(LocalDate dataInizioPeriodo, LocalDate dataFinePeriodo);
}
