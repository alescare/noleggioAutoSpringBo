package com.example.springboot.NoleggioAutoSpringBoot.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "veicolo")
@Data
public class Auto implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "{NotEmpty.Auto.targa.validation}")
    @Column(name = "targa", unique = true)
    private String targa;

    @NotEmpty(message = "{NotEmpty.Auto.costruttore.validation}")
    @Column(name = "costruttore")
    private String costruttore;

    @NotEmpty(message = "{NotEmpty.Auto.modello.validation}")
    @Column(name = "modello")
    private String modello;

    @Min(value = 1886, message = "{Min.Auto.annoImmatricolazione.validation}") //ufficialmente l'anno della prima auto
    //@AnnoImmatricolazione//controlla che non si inserisca un anno successivo a quello attuale
    @Column(name = "anno_immatricolazione")
    private Integer annoImmatricolazione;

    @NotEmpty(message = "{NotEmpty.Auto.tipologia.validation}")
    @Column(name = "tipologia")
    private String tipologia;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE,  mappedBy = "auto")
    @JsonManagedReference
    private Set<Prenotazione> prenotazioni;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return id.equals(auto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
