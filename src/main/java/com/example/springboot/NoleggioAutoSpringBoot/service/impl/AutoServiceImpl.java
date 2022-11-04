package com.example.springboot.NoleggioAutoSpringBoot.service.impl;

import com.example.springboot.NoleggioAutoSpringBoot.entity.Auto;
import com.example.springboot.NoleggioAutoSpringBoot.repository.AutoRepository;
import com.example.springboot.NoleggioAutoSpringBoot.service.AutoService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class AutoServiceImpl implements AutoService {

    private final AutoRepository autoRepository;

    public AutoServiceImpl(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    @Override
    public void salvaOAggiornaAuto(Auto auto) {
        this.autoRepository.save(auto);
    }

    @Override
    public void cancellaAuto(Auto auto) {
        this.autoRepository.delete(auto);
    }

    @Override
    public Iterable<Auto> getListaAuto() {
        return this.autoRepository.findAll();
    }

    @Override
    public Optional<Auto> getAutoPerId(Long id) {
        return this.autoRepository.findById(id);
    }

    @Override
    public List<Auto> listaAutoDisponibiliNelPeriodo(LocalDate dataInizio, LocalDate dataFine) {
        return this.autoRepository.listaAutoDisponibiliNelPeriodo(dataInizio, dataFine);
    }
}
