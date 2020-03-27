package com.bibliotheque.controller;

import com.bibliotheque.exception.LivreNotFoundexception;
import com.bibliotheque.models.Livre;
import com.bibliotheque.repository.ExemplaireRepository;
import com.bibliotheque.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class LivreController {

    @Autowired
    LivreRepository livreRepository;

    @Autowired
    ExemplaireRepository exemplaireRepository;

    @GetMapping(value = "/livres")
    public List<Livre> listeDeLivre() {
        List<Livre> livres = livreRepository.findAll();

        if (livres.isEmpty()) throw new LivreNotFoundexception("Aucun livre n'est disponible pour le moment");

        return livres;
    }

    @GetMapping(value = "/livre/{livreId}")
    public Livre recupererUnLivreParId(@PathVariable int livreId) {
        Optional<Livre> livre = livreRepository.findById(livreId);

        if (!livre.isPresent())
            throw new LivreNotFoundexception("Le produit correspondant à cet identifiant " + livreId + "n'est pas disponible ou n'existe pas");

        return livre.get();
    }

    /**
     * Quand je veux voir mes emprunts je clique sur mes emprunts et j'affiche tous les livre emprunter par (moi) utilisateur.
     *
     * @param nom
     * @return
     */
    @GetMapping(value = "/listeDeMesLivres")
    public List<Livre> listeDeMesEmprunts(@PathVariable String nom) {

        //TODO finaliser l'implementation
//        Optional<Livre> livres = livreRepository.rechercherTousLesLivresEmprunteParUtilisateur(nom);
//
//        if (!livres.isPresent())
//            throw new LivreNotFoundexception("Vous n'avez aucun emprunt de livre en cours " + nom);

        return listeDeLivre();
    }

    /**
     * Quand je tape un nom de livre (complet) dans ma recherche je veux une list de livre avec le meme nom.
     * Return la liste de livre avec le meme nom que celui en parametre.
     *
     * @param motCle nom du livre à rechercher
     * @return Liste de livre correspondant au resultat de la recherche
     */
    // TODO A SUPPRIMER ET METTRE RECHERCHE AVEC TITRE ET AUTEUR.
//    @GetMapping(value = "/recherParNom")
//    public List<Livre> livresParNom(@PathVariable String titre) {
//        List<Livre> livreParNom = livreRepository.findByTitre(titre);
//        return livreParNom;
//    }

    @GetMapping(value = "/recherche")
    List<Livre> rechercherLivres(@RequestParam("motCle") String motCle){
    String motCleRecherche = "%" + motCle + "%"; // A METTRE DANS LE SERVICE

        return livreRepository.rechercherParAuteurOuTitre(motCleRecherche);
    }

}
