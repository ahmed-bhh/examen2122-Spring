package com.apex.clinique.service;


import com.apex.clinique.entities.Clinique;
import com.apex.clinique.entities.Medecin;
import com.apex.clinique.entities.Patient;

public interface IexamenService
{
    public Clinique addClinique (Clinique clinique);
    public Medecin addMedecinAndAssignToClinique (Medecin medecin, Long cliniqueId);
    public Patient addPatient(Patient patient);
}
