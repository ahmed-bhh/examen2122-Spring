package com.apex.clinique.controller;

import com.apex.clinique.entities.Clinique;
import com.apex.clinique.entities.Medecin;
import com.apex.clinique.entities.Patient;
import com.apex.clinique.repositories.CliniqueRepository;
import com.apex.clinique.service.IexamenService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level= AccessLevel.PUBLIC)
@RequestMapping("/examen")
public class ExamenController {
    IexamenService iExamenService;
    @PutMapping("/addClinique")
    public Clinique addClinique(@RequestBody Clinique clinique){
        return iExamenService.addClinique(clinique);
    }
    @PutMapping("/addMedecinAndAssignToClinique/{idclinique}")
    public Medecin addClinique(@RequestBody Medecin medecin, @PathVariable Long idclinique){
        return iExamenService.addMedecinAndAssignToClinique(medecin,idclinique);
    }
    @PutMapping("/addPatient/")
    public Patient addPatient(@RequestBody Patient patient){
        return iExamenService.addPatient(patient);
    }
}
