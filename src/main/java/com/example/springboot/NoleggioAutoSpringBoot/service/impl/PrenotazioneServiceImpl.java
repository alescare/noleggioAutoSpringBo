package com.example.springboot.NoleggioAutoSpringBoot.service.impl;

import com.example.springboot.NoleggioAutoSpringBoot.entity.Prenotazione;
import com.example.springboot.NoleggioAutoSpringBoot.entity.Utente;
import com.example.springboot.NoleggioAutoSpringBoot.repository.PrenotazioneRepository;
import com.example.springboot.NoleggioAutoSpringBoot.service.PrenotazioneService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class PrenotazioneServiceImpl implements PrenotazioneService {

    private final PrenotazioneRepository prenotazioneRepository;

    public PrenotazioneServiceImpl(PrenotazioneRepository prenotazioneRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
    }

    @Override
    public void salvaOAggiornaPrenotazione(Prenotazione prenotazione) {
        this.prenotazioneRepository.save(prenotazione);
    }

    @Override
    public Iterable<Prenotazione> getPrenotazioni() {
        return this.prenotazioneRepository.findAll();
    }

    @Override
    public Optional<Prenotazione> getPrenotazione(Long id) {
        return this.prenotazioneRepository.findById(id);
    }

    @Override
    public List<Prenotazione> getPrenotazioniDaApprovare() {
        return this.prenotazioneRepository.getPrenotazioniDaApprovare();
    }

    @Override
    public List<Prenotazione> getPrenotazioniUtente(Utente utente) {
        return this.prenotazioneRepository.getPrenotazioniUtente(utente);
    }

    @Override
    public boolean prenotazioneInCorsoUtente(Utente utente) {
        return this.prenotazioneRepository.prenotazioneInCorsoUtente(utente);
    }

    @Override
    public void cancellaPrenotazione(Prenotazione prenotazione) {
        this.prenotazioneRepository.delete(prenotazione);
    }

    @Override
    public List<Prenotazione> getListaPrenotazioniNelPeriodo(LocalDate dataInizioPeriodo, LocalDate dataFinePeriodo) {
        return this.prenotazioneRepository.getListaPrenotazioniNelPeriodo(dataInizioPeriodo, dataFinePeriodo);
    }
}
