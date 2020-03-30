package com.bibliotheque.service.impl;

import com.bibliotheque.models.Exemplaire;
import com.bibliotheque.repository.ExemplaireRepository;
import com.bibliotheque.service.ExemplaireService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ExemplaireServiceImpl implements ExemplaireService {

    @Autowired
    ExemplaireRepository exemplaireRepository;

    @Override
    public List<Exemplaire> rechercherTousLesExemplairesPourUtilisateur(int id) {

        return exemplaireRepository.rechercherTousLesToposPourUtilisateur(id);
    }
}
