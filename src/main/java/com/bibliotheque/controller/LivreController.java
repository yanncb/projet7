package com.bibliotheque.controller;

import com.bibliotheque.exception.LivreNotFoundexception;
import com.bibliotheque.models.Exemplaire;
import com.bibliotheque.models.Livre;
import com.bibliotheque.service.ExemplaireService;
import com.bibliotheque.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LivreController {

    @Autowired
    LivreService livreService;

    @Autowired
    ExemplaireService exemplaireService;


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


    @GetMapping(value = "/recherche")
    List<Livre> rechercherLivres(@RequestParam("motCle") String motCle) {
        String motCleRecherche = "%" + motCle + "%";

        return livreService.rechercherParAuteurOuTitre(motCleRecherche);
    }

    @GetMapping(value = "liste-de-mes-emprunts/{utilisateurId}")
    public List<Livre> exemplaireList(@PathVariable("utilisateurId") Integer id) {
        List<Livre> livreList = livreService.rechercherTousLesLivresPourUtilisateur(id);
        return livreList;
    }
//
//    @GetMapping(value = "liste-de-mes-emprunts/{utilisateurId}")
//    public List<Exemplaire> exemplaireList(@PathVariable("utilisateurId") Integer id) {
//        List<Exemplaire> exemplairesList = livreService.rechercherTousLesExemplairesPourUtilisateur(id);
//        return exemplairesList;
//    }

    @PostMapping("prolonger-emprunt/{exemplaireId}")
    public Exemplaire prolongerEmprunt(@PathVariable("exemplaireId") Integer id) {
        Exemplaire exemplaire = livreService.prolongerEmPrunt(id);
        return exemplaire;
    }

}
