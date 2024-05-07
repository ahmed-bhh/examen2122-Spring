package com.apex.clinique.repositories;

import com.apex.clinique.entities.Medecin;
import com.apex.clinique.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous,Long> {
}
