package com.apex.clinique.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedecin;
    private String nomMedecin;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    private Integer telephone;
    private Integer prixConsultation;
    @ManyToMany(mappedBy="medecins", cascade = CascadeType.ALL)
    private List<Clinique> cliniques;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="medecin")
    private List<RendezVous> RendezVouss;


}
