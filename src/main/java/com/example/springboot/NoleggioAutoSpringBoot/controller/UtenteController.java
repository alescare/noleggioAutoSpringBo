package com.example.springboot.NoleggioAutoSpringBoot.controller;

import com.example.springboot.NoleggioAutoSpringBoot.dto.UtenteDto;
import com.example.springboot.NoleggioAutoSpringBoot.service.UtenteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/utente")
public class UtenteController {

    private final UtenteService utenteService;

    public UtenteController(UtenteService utenteService) {
        this.utenteService = utenteService;
    }

    @PostMapping(value = "/salva_aggiorna_utente")
    public ResponseEntity salvaAggiornaUtente(@RequestBody UtenteDto utenteDto) {
        this.utenteService.salvaOAggiornaUtente(utenteDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(value = "/cancella/{idUtente}")
    public ResponseEntity cancellaUtente(@PathVariable("idUtente") Long idUtente) {
        this.utenteService.cancellaUtentePerId(idUtente);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/lista_utenti")
    public ResponseEntity<List<UtenteDto>> listaUtenti() {
        List<UtenteDto> listaUtenti = this.utenteService.listaUtenti();
        return new ResponseEntity<>(listaUtenti, HttpStatus.OK);
    }

    @GetMapping(value = "/dati_utente/{idUtente}")
    public ResponseEntity<UtenteDto> datiUtente(@PathVariable("idUtente") Long idUtente) {
        UtenteDto utente = this.utenteService.cercaUtentePerId(idUtente);
        return new ResponseEntity<>(utente, HttpStatus.OK);
    }

}
