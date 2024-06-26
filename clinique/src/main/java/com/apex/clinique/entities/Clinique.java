package com.apex.clinique.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Clinique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClinique;
    private String nomClinique;
    private String adresse;
    private Integer telephone;
    //@JsonManagedReference
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Medecin> medecins;

}
