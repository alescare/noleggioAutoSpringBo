package com.example.springboot.NoleggioAutoSpringBoot.controller;

import com.example.springboot.NoleggioAutoSpringBoot.dto.AutoDto;
import com.example.springboot.NoleggioAutoSpringBoot.service.AutoService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/auto")
public class AutoController {

    private final AutoService autoService;

    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }

    @DeleteMapping(value = "/elimina/{idAuto}")
    public ResponseEntity eliminaAutoPerId(@PathVariable("idAuto") Long idAuto) {
        this.autoService.cancellaAutoPerId(idAuto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/salva_aggiorna_auto")
    public ResponseEntity<AutoDto> salvaOAggiornaAuto(@RequestBody AutoDto autoDto) {
        return new ResponseEntity<>(this.autoService.salvaOAggiornaAuto(autoDto), HttpStatus.OK);
    }

    @GetMapping(value = "/lista_auto")
    public ResponseEntity<List<AutoDto>> getListaAuto() {
        List<AutoDto> listaAuto = this.autoService.listaAuto();
        return new ResponseEntity<>(listaAuto, HttpStatus.OK);
    }

    @GetMapping(value = "/lista_auto_disponibili")
    public ResponseEntity<List<AutoDto>> getListaAutoDisponibili(@DateTimeFormat(pattern="dd-MM-yyyy") @RequestParam("dataInizioPeriodo") LocalDate dataInizioPeriodo, @DateTimeFormat(pattern="dd-MM-yyyy") @RequestParam("dataFinePeriodo") LocalDate dataFinePeriodo) {
        List<AutoDto> listaAuto = this.autoService.listaAutoDisponibiliNelPeriodo(dataInizioPeriodo, dataFinePeriodo);
        return new ResponseEntity<>(listaAuto, HttpStatus.OK);
    }

    @GetMapping(value = "/{idAuto}")
    public ResponseEntity<AutoDto> getAutoPerId(@PathVariable("idAuto") Long idAuto) {
        AutoDto auto = this.autoService.autoPerId(idAuto);
        return new ResponseEntity<>(auto, HttpStatus.OK);
    }


}
