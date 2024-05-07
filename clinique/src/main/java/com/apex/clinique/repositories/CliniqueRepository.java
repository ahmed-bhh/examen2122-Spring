package com.apex.clinique.repositories;

import com.apex.clinique.entities.Clinique;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CliniqueRepository extends JpaRepository<Clinique,Long> {
}
