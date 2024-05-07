package com.apex.clinique.repositories;

import com.apex.clinique.entities.Medecin;
import com.apex.clinique.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
