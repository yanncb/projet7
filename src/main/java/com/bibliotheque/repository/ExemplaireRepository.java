package com.bibliotheque.repository;

import com.bibliotheque.models.Exemplaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExemplaireRepository extends JpaRepository<Exemplaire, Integer> {

    }
