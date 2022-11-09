package com.example.springboot.NoleggioAutoSpringBoot.service.impl;

import com.example.springboot.NoleggioAutoSpringBoot.dto.PrenotazioneDto;
import com.example.springboot.NoleggioAutoSpringBoot.entity.Prenotazione;
import com.example.springboot.NoleggioAutoSpringBoot.repository.PrenotazioneRepository;
import com.example.springboot.NoleggioAutoSpringBoot.service.PrenotazioneService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class PrenotazioneServiceImpl implements PrenotazioneService {

    private final PrenotazioneRepository prenotazioneRepository;

    private final ModelMapper modelMapper;

    public PrenotazioneServiceImpl(PrenotazioneRepository prenotazioneRepository, ModelMapper modelMapper) {
        this.prenotazioneRepository = prenotazioneRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void salvaOAggiornaPrenotazione(PrenotazioneDto prenotazioneDto) {
        Prenotazione prenotazione = this.modelMapper.map(prenotazioneDto, Prenotazione.class);
        this.prenotazioneRepository.save(prenotazione);
    }

    @Override
    public List<PrenotazioneDto> listaPrenotazioni() {
        List<PrenotazioneDto> listaPrenotazioni = new LinkedList<>();
        this.prenotazioneRepository.findAll().forEach(prenotazione -> listaPrenotazioni.add(modelMapper.map(prenotazione, PrenotazioneDto.class)));
        return listaPrenotazioni;
    }

    @Override
    public List<PrenotazioneDto> prenotazioniDaApprovare() {

        List<PrenotazioneDto> listaPrenotazioni = new LinkedList<>();
        this.prenotazioneRepository.findByApprovata(false).forEach(prenotazione -> listaPrenotazioni.add(modelMapper.map(prenotazione, PrenotazioneDto.class)));
        return listaPrenotazioni;
    }

    @Override
    public List<PrenotazioneDto> prenotazioniUtente(Long idUtente) {
        List<PrenotazioneDto> listaPrenotazioni = new LinkedList<>();
        this.prenotazioneRepository.findByUtente_Id(idUtente).forEach(prenotazione -> listaPrenotazioni.add(modelMapper.map(prenotazione, PrenotazioneDto.class)));
        return listaPrenotazioni;
    }

    @Override
    public boolean prenotazioneInCorsoUtente(Long idUtente) {
        Prenotazione prenotazione = this.prenotazioneRepository.findTopByUtente_Id(idUtente);
        return prenotazione != null && (prenotazione.getDataFine().isAfter(LocalDate.now()) || prenotazione.getDataFine().isEqual(LocalDate.now()));
    }

    @Override
    public void cancellaPrenotazionePerId(Long id) {
        this.prenotazioneRepository.deleteById(id);
    }

    @Override
    public List<Long> getListaIdAutoOccupate(LocalDate dataInizio, LocalDate dataFine) {
        return  this.prenotazioneRepository.listaPrenotazioniInConflitto(dataInizio, dataFine);
    }
}
