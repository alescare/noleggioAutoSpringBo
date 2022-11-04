package com.example.springboot.NoleggioAutoSpringBoot.repository;

import com.example.springboot.NoleggioAutoSpringBoot.entity.Auto;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface AutoRepository extends CrudRepository<Auto, Long> {

   public List<Auto> listaAutoDisponibiliNelPeriodo(LocalDate dataInizio, LocalDate dataFine);
}
