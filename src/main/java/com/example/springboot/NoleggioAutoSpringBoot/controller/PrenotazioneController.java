package com.example.springboot.NoleggioAutoSpringBoot.controller;

import com.example.springboot.NoleggioAutoSpringBoot.service.AutoService;
import com.example.springboot.NoleggioAutoSpringBoot.service.PrenotazioneService;
import com.example.springboot.NoleggioAutoSpringBoot.service.UtenteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/prenotazione")
public class PrenotazioneController {

    private final PrenotazioneService prenotazioneService;

    private final AutoService autoService;

    private final UtenteService utenteService;

    public PrenotazioneController(PrenotazioneService prenotazioneService, AutoService autoService, UtenteService utenteService) {
        this.prenotazioneService = prenotazioneService;
        this.autoService = autoService;
        this.utenteService = utenteService;
    }

   }
