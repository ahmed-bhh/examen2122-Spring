package com.apex.clinique.service;

import com.apex.clinique.entities.Clinique;
import com.apex.clinique.entities.Medecin;
import com.apex.clinique.entities.Patient;
import com.apex.clinique.repositories.CliniqueRepository;
import com.apex.clinique.repositories.MedecinRepository;
import com.apex.clinique.repositories.PatientRepository;
import com.apex.clinique.repositories.RendezVousRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ExamenServiceImpl implements IexamenService{
    @Autowired
    CliniqueRepository cliniqueRepository;
    @Autowired
    MedecinRepository medecinRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    RendezVousRepository rendezVousRepository;

    @Override
    public Clinique addClinique(Clinique clinique) {
        return cliniqueRepository.save(clinique);
    }

    @Override
    public Medecin addMedecinAndAssignToClinique(Medecin medecin, Long cliniqueId) {
        Clinique clinique=cliniqueRepository.findById(cliniqueId).get();
        List<Medecin> medecinNewList=new ArrayList<>();

        if(clinique.getMedecins()!=null){
            medecinNewList=clinique.getMedecins();
        }

        medecinNewList.add(medecin);
        clinique.setMedecins(medecinNewList);

        medecinRepository.save(medecin);
        cliniqueRepository.save(clinique);



        return medecin;
    }

    @Override
    public Patient addPatient(Patient patient) {

        return patientRepository.save(patient);
    }

}
