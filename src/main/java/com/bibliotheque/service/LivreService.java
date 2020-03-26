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


}
