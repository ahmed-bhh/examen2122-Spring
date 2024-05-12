package com.apex.clinique.controller;

import com.apex.clinique.entities.*;
import com.apex.clinique.repositories.CliniqueRepository;
import com.apex.clinique.service.IexamenService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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
    @PutMapping("/addRDVAndAssignMedAndPatient/{idmedecin}/{idpatient}")
    public void addRDVAndAssignMedAndPatient(@RequestBody RendezVous rdv,@PathVariable Long idmedecin,@PathVariable Long idpatient){
         iExamenService.addRDVAndAssignMedAndPatient(rdv,idmedecin,idpatient);
    }
    @PutMapping("/getRendezVousByCliniqueAndSpecialite/{idClinique}/{specialite}")
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(@PathVariable Long idClinique, @PathVariable Specialite specialite){
      return   iExamenService.getRendezVousByCliniqueAndSpecialite(idClinique,specialite);
    }
    @PutMapping("/getNbrRendezVousMedecin/{idmedecin}")
    public int  getNbrRendezVousMedecin(@PathVariable Long idmedecin){
        return   iExamenService.getNbrRendezVousMedecin(idmedecin);
    }
    @PutMapping("/getRevenuMedecin/{idMedecin}/{startDate}/{endDate}")
    public int getRevenuMedecin (
            @PathVariable("idMedecin") Long idMedecin,
            @PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd")Date endDate
    )
    {
        return   iExamenService.getRevenuMedecin(idMedecin,startDate,endDate);
    }
}
