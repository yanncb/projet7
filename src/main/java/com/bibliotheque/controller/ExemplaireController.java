package com.bibliotheque.controller;

import com.bibliotheque.models.Exemplaire;
import com.bibliotheque.service.ExemplaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExemplaireController {

    @Autowired
    ExemplaireService exemplaireService;

    @GetMapping(value = "liste-de-mes-emprunts")
    public List<Exemplaire> exemplaireList(@RequestParam("utilisateurId")Integer id){
      List<Exemplaire> exemplaire = exemplaireService.rechercherTousLesExemplairesPourUtilisateur(id);
        return exemplaire;
    }

}
