package com.example.springboot.NoleggioAutoSpringBoot.service.impl;

import com.example.springboot.NoleggioAutoSpringBoot.dto.UtenteDto;
import com.example.springboot.NoleggioAutoSpringBoot.entity.Utente;
import com.example.springboot.NoleggioAutoSpringBoot.repository.UtenteRepository;
import com.example.springboot.NoleggioAutoSpringBoot.service.UtenteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class UtenteServiceImpl implements UtenteService {

    private final UtenteRepository utenteRepository;
    private final ModelMapper modelMapper;

    public UtenteServiceImpl(UtenteRepository utenteRepository, ModelMapper modelMapper) {
        this.utenteRepository = utenteRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void salvaOAggiornaUtente(UtenteDto utenteDto) {
        Utente utente = this.modelMapper.map(utenteDto, Utente.class);
        if(utenteDto.getId() != null) {
           utente.setPrenotazioni(this.utenteRepository.findById(utenteDto.getId()).get().getPrenotazioni());
        }
        this.utenteRepository.save(utente);
    }

    @Override
    public UtenteDto cercaUtentePerUsername(String username) {
        return modelMapper.map(this.utenteRepository.findByUsername(username), UtenteDto.class);
    }

    @Override
    public List<UtenteDto> listaUtenti() {
        List<UtenteDto> listaUtenti = new LinkedList<>();
        this.utenteRepository.findAll().forEach(utente -> listaUtenti.add(modelMapper.map(utente, UtenteDto.class)));
        return listaUtenti;
    }

    @Override
    public UtenteDto cercaUtentePerId(Long id) {
        return modelMapper.map(this.utenteRepository.findById(id).get(), UtenteDto.class);
    }

    @Override
    public void cancellaUtentePerId(Long id) {
        this.utenteRepository.deleteById(id);
    }
}
