package com.example.springboot.NoleggioAutoSpringBoot.repository;

import com.example.springboot.NoleggioAutoSpringBoot.entity.Utente;
import org.springframework.data.repository.CrudRepository;

public interface UtenteRepository extends CrudRepository<Utente, Long> {


    //public Utente cercaUtentePerCredenziali(String email, String password);

    Utente cercaUtentePerUsername(String username);

}
