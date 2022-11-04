package com.example.springboot.NoleggioAutoSpringBoot.service;

import com.example.springboot.NoleggioAutoSpringBoot.entity.Utente;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UtenteService {

    public void salvaOAggiornaUtente(Utente utente);

    public Utente cercaUtentePerCredenziali(String email, String password);

    public Utente cercaUtentePerUsername(String username);


    public Iterable<Utente> listaUtenti();


    public Optional<Utente> cercaUtentePerId(Long id);


    public void cancellaUtente(Utente utente);

    public void cancellaUtentePerId(Long id);
}
