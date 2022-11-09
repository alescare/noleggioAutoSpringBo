package com.example.springboot.NoleggioAutoSpringBoot.service.impl;

import com.example.springboot.NoleggioAutoSpringBoot.dto.AutoDto;
import com.example.springboot.NoleggioAutoSpringBoot.entity.Auto;
import com.example.springboot.NoleggioAutoSpringBoot.repository.AutoRepository;
import com.example.springboot.NoleggioAutoSpringBoot.service.AutoService;
import com.example.springboot.NoleggioAutoSpringBoot.service.PrenotazioneService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AutoServiceImpl implements AutoService {

    private final AutoRepository autoRepository;

    private final PrenotazioneService prenotazioneService;

    private final ModelMapper modelMapper;

    public AutoServiceImpl(AutoRepository autoRepository, PrenotazioneService prenotazioneService, ModelMapper modelMapper) {
        this.autoRepository = autoRepository;
        this.prenotazioneService = prenotazioneService;
        this.modelMapper = modelMapper;
    }

    @Override
    public AutoDto salvaOAggiornaAuto(AutoDto autoDto) {
        Auto auto = this.modelMapper.map(autoDto, Auto.class);
        return this.modelMapper.map(autoRepository.save(auto), AutoDto.class);
    }

    @Override
    public void cancellaAutoPerId(Long id) {
        this.autoRepository.deleteById(id);
    }

    @Override
    public List<AutoDto> listaAuto() {

        List<AutoDto> listaAuto = new LinkedList<>();
        this.autoRepository.findAll().forEach(auto -> listaAuto.add(modelMapper.map(auto, AutoDto.class)));
        return listaAuto;
    }

    @Override
    public AutoDto autoPerId(Long id) {
        return modelMapper.map(this.autoRepository.findById(id).get(), AutoDto.class);
    }

    @Override
    public List<AutoDto> listaAutoDisponibiliNelPeriodo(LocalDate dataInizio, LocalDate dataFine) {
        List<Long> listaAutoOccupate = this.prenotazioneService.getListaIdAutoOccupate(dataInizio, dataFine);
        if (listaAutoOccupate.isEmpty()) {
            return autoRepository.findAll().stream().map(auto -> this.modelMapper.map(auto, AutoDto.class)).collect(Collectors.toList());
        }
        return autoRepository.findAllByIdNotIn(listaAutoOccupate).stream().map(auto -> this.modelMapper.map(auto, AutoDto.class)).collect(Collectors.toList());
    }
}
