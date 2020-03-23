package com.bibliotheque.service.impl;

import com.bibliotheque.models.Livre;
import com.bibliotheque.repository.LivreRepository;
import com.bibliotheque.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class LivreServiceImpl implements LivreService {

    @Autowired
    LivreRepository livreRepository;

    @Override
    public List<Livre> rechercherTousLesLivres() {
        return livreRepository.findAll();
    }

    @Override
    public void ajouterLivre(Livre livre) {
        livre.setAuteur(livre.getAuteur());
        livre.setDate(Date.from(Instant.now()));
        livre.setNbDispo(livre.getNbDispo());
        livre.setNom(livre.getNom());
        livre.setPret(false);
        livreRepository.save(livre);
    }
}
