package com.apex.clinique.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatient;
    private  String nomPatient;
    private Integer telephone;
    private Date dateNaissance;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="patient")
   // @JsonIgnoreProperties("patient")
    private List<RendezVous> RendezVouss;


}
