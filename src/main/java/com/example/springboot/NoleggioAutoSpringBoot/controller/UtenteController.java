package com.example.springboot.NoleggioAutoSpringBoot.controller;

import com.example.springboot.NoleggioAutoSpringBoot.service.PrenotazioneService;
import com.example.springboot.NoleggioAutoSpringBoot.service.UtenteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/utente")
public class UtenteController {

    private final UtenteService utenteService;

    private final PrenotazioneService prenotazioneService;

    public UtenteController(UtenteService utenteService, PrenotazioneService prenotazioneService) {
        this.utenteService = utenteService;
        this.prenotazioneService = prenotazioneService;
    }


}
