package com.bibliotheque.service;

import com.bibliotheque.models.Exemplaire;

import java.util.Optional;

public interface ExemplaireService {

    Optional<Exemplaire> findById(Integer id);
}
