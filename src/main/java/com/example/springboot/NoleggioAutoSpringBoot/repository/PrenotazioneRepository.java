package com.example.springboot.NoleggioAutoSpringBoot.repository;

import com.example.springboot.NoleggioAutoSpringBoot.entity.Prenotazione;
import com.example.springboot.NoleggioAutoSpringBoot.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    List<Prenotazione> findByUtente_Id(Long id);

    List<Prenotazione> findByApprovata(boolean approvata);

    Prenotazione findTopByUtente_Id(Long id);

    @Query(value = "select p.auto.id from Prenotazione p where (p.dataInizio <= (:dataInizioPeriodo) and p.dataFine >= (:dataFinePeriodo)) or (p.dataInizio BETWEEN (:dataInizioPeriodo) and (:dataFinePeriodo)) or (p.dataFine BETWEEN (:dataInizioPeriodo) and (:dataFinePeriodo))")
    List<Long> listaPrenotazioniInConflitto(@Param("dataInizioPeriodo") LocalDate dataInizioPeriodo, @Param("dataFinePeriodo") LocalDate dataFinePeriodo);

    /* public List<Prenotazione> findByDataInizioLessThanEqualAndDataFineGreaterThanEqual(LocalDate dataInizioPeriodo, LocalDate dataFinePeriodo);

    public List<Prenotazione> findByDataInizioBetweenOrDataFineBetween(LocalDate dataInizioPeriodo, LocalDate dataFinePeriodo, LocalDate dataInizioPeriodo2, LocalDate dataFinePeriodo2);

    public List<Prenotazione> findByDataFineBetween();
 static final String query = "lijl";*/

    /*p JOIN a.barcode b WHERE b.barcode IN (:ean)
    public List<Prenotazione> listaPrenotazioniNelPeriodo(LocalDate dataInizioPeriodo, LocalDate dataFinePeriodo);*/

}
