package com.example.springboot.NoleggioAutoSpringBoot.service;

import com.example.springboot.NoleggioAutoSpringBoot.entity.Auto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public interface AutoService {

    public void salvaOAggiornaAuto(Auto auto);

    public void cancellaAuto(Auto auto);

    public Iterable<Auto> getListaAuto();

    public Optional<Auto> getAutoPerId(Long id);

    public List<Auto> listaAutoDisponibiliNelPeriodo(LocalDate dataInizio, LocalDate dataFine);
    /*
    * public Iterable<Articoli> SelTutti();

	public List<ArticoliDto> SelByDescrizione(String descrizione);

	public List<Articoli> SelByDescrizione(String descrizione, Pageable pageable);

	public ArticoliDto SelByCodArt(String codArt);

	public Articoli SelByCodArt2(String codArt);

	public ArticoliDto SelByBarcode(String barcode);

	public void DelArticolo(Articoli articolo);

	public void InsArticolo(Articoli articolo);*/
}
