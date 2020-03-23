package com.bibliotheque.service;


import com.bibliotheque.models.Livre;
import com.bibliotheque.models.Utilisateur;

import java.util.List;

public interface LivreService {

    /**
     * Permets de chercher tous les utilisateurs
     *
     * @return liste d'utilisateur
     */
    List<Livre> rechercherTousLesLivres();

    /**
     * ajouter Utilisateur
     *
     * @param livre information d'un utilisateur pour sauvegard en base
     */
    void ajouterLivre(Livre livre);
}
