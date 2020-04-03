package com.bibliotheque.service;

import com.bibliotheque.models.Livre;

import java.util.List;

public interface LivreService {

    /**
     * Permets de chercher tous les utilisateurs
     *
     * @return liste d'utilisateur
     */
    List<Livre> rechercherTousLesLivres();

    /**
     * Permets de cherche un livre par son id
     *
     * @param id identifiant unique
     * @return livre
     */
    Livre findById(Integer id);

    /**
     * Rechercher une liste de livre par un mot clé
     *
     * @param motCle nom ou titre
     * @return le LIVRE
     */
    List<Livre> rechercherParAuteurOuTitre(String motCle);

    /**
     *
     * @param id
     * @return
     */
    List<Livre> rechercherTousLesLivresPourUtilisateur(int id);

}
