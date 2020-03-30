package com.bibliotheque.service;

import com.bibliotheque.models.Exemplaire;

import java.util.List;

public interface ExemplaireService {

    List<Exemplaire> rechercherTousLesExemplairesPourUtilisateur(int id);

}
