package com.apex.clinique.service;


import com.apex.clinique.entities.*;

import java.util.Date;
import java.util.List;

public interface IexamenService
{
    public Clinique addClinique (Clinique clinique);
    public Medecin addMedecinAndAssignToClinique (Medecin medecin, Long cliniqueId);
    public Patient addPatient(Patient patient);
    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient);
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite);
    public int getNbrRendezVousMedecin(Long idMedecin) ;
    public void retrieveRendezVous();
    public int getRevenuMedecin( Long idMedecin, Date startDate, Date endDate);
}
