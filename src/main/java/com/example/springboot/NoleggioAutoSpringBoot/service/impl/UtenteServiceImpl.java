package com.example.springboot.NoleggioAutoSpringBoot.service.impl;

import com.example.springboot.NoleggioAutoSpringBoot.entity.Utente;
import com.example.springboot.NoleggioAutoSpringBoot.repository.UtenteRepository;
import com.example.springboot.NoleggioAutoSpringBoot.service.UtenteService;

import java.util.Optional;

public class UtenteServiceImpl implements UtenteService {

    private final UtenteRepository utenteRepository;

    public UtenteServiceImpl(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    @Override
    public void salvaOAggiornaUtente(Utente utente) {
        this.utenteRepository.save(utente);
    }

    @Override
    public Utente cercaUtentePerCredenziali(String email, String password) {
        return null;
    }

    @Override
    public Utente cercaUtentePerUsername(String username) {
        return this.utenteRepository.cercaUtentePerUsername(username);
    }

    @Override
    public Iterable<Utente> listaUtenti() {
        return this.utenteRepository.findAll();
    }

    @Override
    public Optional<Utente> cercaUtentePerId(Long id) {
        return this.utenteRepository.findById(id);
    }

    @Override
    public void cancellaUtente(Utente utente) {
        this.utenteRepository.delete(utente);
    }

    @Override
    public void cancellaUtentePerId(Long id) {
        this.utenteRepository.deleteById(id);
    }
}
