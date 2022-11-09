package com.example.springboot.NoleggioAutoSpringBoot.service;

import com.example.springboot.NoleggioAutoSpringBoot.dto.AutoDto;

import java.time.LocalDate;
import java.util.List;


public interface AutoService {

    AutoDto salvaOAggiornaAuto(AutoDto autoDto);

    void cancellaAutoPerId(Long id);

    List<AutoDto> listaAuto();

    AutoDto autoPerId(Long id);

    List<AutoDto> listaAutoDisponibiliNelPeriodo(LocalDate dataInizio, LocalDate dataFine);

}
