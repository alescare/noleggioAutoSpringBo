package com.example.springboot.NoleggioAutoSpringBoot.controller;

import com.example.springboot.NoleggioAutoSpringBoot.dto.PrenotazioneDto;
import com.example.springboot.NoleggioAutoSpringBoot.service.PrenotazioneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/prenotazione")
public class PrenotazioneController {

    private final PrenotazioneService prenotazioneService;


    public PrenotazioneController(PrenotazioneService prenotazioneService) {
        this.prenotazioneService = prenotazioneService;
    }

    @PostMapping(value = "/salva_aggiorna_prenotazione")
    public ResponseEntity salvaAggiornaPrenotazione(@RequestBody PrenotazioneDto prenotazioneDto) {
        this.prenotazioneService.salvaOAggiornaPrenotazione(prenotazioneDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/lista_prenotazioni")
    public ResponseEntity<List<PrenotazioneDto>> getPrenotazioni() {
        List<PrenotazioneDto> listaPrenotazioni = this.prenotazioneService.listaPrenotazioni();
        return new ResponseEntity<>(listaPrenotazioni, HttpStatus.OK);
    }

    @GetMapping(value = "/lista_prenotazioni_da_approvare")
    public ResponseEntity<List<PrenotazioneDto>> getPrenotazioniDaApprovare() {
        List<PrenotazioneDto> listaPrenotazioni = this.prenotazioneService.prenotazioniDaApprovare();
        return new ResponseEntity<>(listaPrenotazioni, HttpStatus.OK);
    }

    @GetMapping(value = "/prenotazione_in_corso/{idUtente}")
    public ResponseEntity<Boolean> prenotazioneInCorsoUtente(@PathVariable("idUtente") Long idUtente) {
        boolean prenotazioneInCorsoUtente = this.prenotazioneService.prenotazioneInCorsoUtente(idUtente);
        return new ResponseEntity<>(prenotazioneInCorsoUtente, HttpStatus.OK);
    }

    @GetMapping(value = "/prenotazioni_utente/{idUtente}")
    public ResponseEntity<List<PrenotazioneDto>> prenotazioniUtente(@PathVariable("idUtente") Long idUtente) {
        List<PrenotazioneDto> listaPrenotazioni = this.prenotazioneService.prenotazioniUtente(idUtente);
        return new ResponseEntity<>(listaPrenotazioni, HttpStatus.OK);
    }

    @DeleteMapping(value = "/elimina/{idPrenotazione}")
    public ResponseEntity eliminaPrenotazionePerId(@PathVariable("idPrenotazione") Long idPrenotazione) {
        this.prenotazioneService.cancellaPrenotazionePerId(idPrenotazione);
        return new ResponseEntity(HttpStatus.OK);
    }

}
