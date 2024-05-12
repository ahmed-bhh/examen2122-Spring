package com.apex.clinique.service;

import com.apex.clinique.entities.*;
import com.apex.clinique.repositories.CliniqueRepository;
import com.apex.clinique.repositories.MedecinRepository;
import com.apex.clinique.repositories.PatientRepository;
import com.apex.clinique.repositories.RendezVousRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
      /*  Clinique clinique=cliniqueRepository.findById(cliniqueId).get();
        List<Medecin> medecinNewList=new ArrayList<>();

        if(clinique.getMedecins()!=null){
            medecinNewList=clinique.getMedecins();
        }

        medecinNewList.add(medecin);
        clinique.setMedecins(medecinNewList);

        medecinRepository.save(medecin);
        cliniqueRepository.save(clinique);
*/

   Clinique thecnlique=cliniqueRepository.findById(cliniqueId).get();
        thecnlique.getMedecins().add(medecin);
        medecinRepository.save(medecin);
        cliniqueRepository.save(thecnlique);


        return medecin;
    }

    @Override
    public Patient addPatient(Patient patient) {

        return patientRepository.save(patient);
    }

    @Override
    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient) {
        Medecin medecin= medecinRepository.findById(idMedecin).get();
        Patient patient=patientRepository.findById(idPatient).get();
        rdv.setMedecin(medecin);
        rdv.setPatient(patient);
        rendezVousRepository.save(rdv);


    }

    @Override
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite) {
        Clinique cnlique=cliniqueRepository.findById(idClinique).get();
       List<Medecin> tobba_lkol= cnlique.getMedecins();
       List<RendezVous> les_rendezvous_mabaadhhom=new ArrayList<>();
        for(Medecin medecin:tobba_lkol){
            System.out.println(medecin.getSpecialite());
            if(medecin.getSpecialite()==specialite){
                les_rendezvous_mabaadhhom.addAll(medecin.getRendezVouss());

            }
        }

//houni habit nchouf f terminal kadeh aandi min rendez vous
for(RendezVous test:les_rendezvous_mabaadhhom){
    System.out.println(test.getIdRDV());
}
return les_rendezvous_mabaadhhom;
    }

    @Override
    public int getNbrRendezVousMedecin(Long idMedecin) {
        Medecin medecin= medecinRepository.findById(idMedecin).get();

        return         medecin.getRendezVouss().size();

    }

    @Scheduled(fixedRate = 30000)
    @Override
    public void retrieveRendezVous() {

          List<RendezVous> tous_les_rendez_vous=rendezVousRepository.findAll();
          for (RendezVous rendezVous:tous_les_rendez_vous){
              System.out.println("liste des rendez vous "+rendezVous.getDateRDV()+"medecin "+rendezVous.getMedecin().getNomMedecin()+"patient: "+rendezVous.getPatient().getNomPatient()+"\n");

          }

    }

    @Override
    public int getRevenuMedecin(Long idMedecin, Date startDate, Date endDate) {
        Medecin medecin= medecinRepository.findById(idMedecin).get();
        int revenu=0;
        for(RendezVous rendezVous:medecin.getRendezVouss()){

            if(rendezVous.getDateRDV().before(endDate)&&rendezVous.getDateRDV().after(startDate)){
                 revenu=revenu+medecin.getPrixConsultation();
            }


        }

        return revenu;
    }

}


