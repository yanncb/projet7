package com.bibliotheque.controller;

import com.bibliotheque.models.Exemplaire;
import com.bibliotheque.service.ExemplaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExemplaireController {

    @Autowired
    ExemplaireService exemplaireService;

    @GetMapping(value = "liste-de-mes-emprunts/{utilisateurId}")
    public List<Exemplaire> exemplaireList(@PathVariable("utilisateurId") Integer id) {
        List<Exemplaire> exemplaire = exemplaireService.rechercherTousLesExemplairesPourUtilisateur(id);
        return exemplaire;
    }

}
