package com.bibliotheque.controller;

import com.bibliotheque.exception.LivreNotFoundexception;
import com.bibliotheque.models.Livre;
import com.bibliotheque.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LivreController {

    @Autowired
    LivreService livreService;



    @GetMapping(value = "/livres")
    public List<Livre> listeDeLivre() {

        List<Livre> livres = livreService.rechercherTousLesLivres();
        if (livres.isEmpty()) throw new LivreNotFoundexception("Aucun livre n'est disponible pour le moment");

        return livres;
    }

    @GetMapping(value = "/livre/{livreId}")
    public Livre recupererUnLivreParId(@PathVariable int livreId) {
        Livre livre = livreService.findById(livreId);

        return livre;
    }

    /**
     * Quand je veux voir mes emprunts je clique sur mes emprunts et j'affiche tous les livre emprunter par (moi) utilisateur.
     *
     * @param nom
     * @return
     */
    @GetMapping(value = "/listeDeMesLivres/{nom}")
    public List<Livre> listeDeMesEmprunts(@PathVariable String nom) {

        //TODO finaliser l'implementation
//        Optional<Livre> livres = livreRepository.rechercherTousLesLivresEmprunteParUtilisateur(nom);
//
//        if (!livres.isPresent())
//            throw new LivreNotFoundexception("Vous n'avez aucun emprunt de livre en cours " + nom);

        return listeDeLivre();
    }

    @GetMapping(value = "/recherche")
    List<Livre> rechercherLivres(@RequestParam("motCle") String motCle) {
        String motCleRecherche = "%" + motCle + "%";

        return livreService.rechercherParAuteurOuTitre(motCleRecherche);
    }

}
