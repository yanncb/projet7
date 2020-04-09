package com.bibliotheque.service.impl;

import com.bibliotheque.models.Exemplaire;
import com.bibliotheque.models.Livre;
import com.bibliotheque.models.Utilisateur;
import com.bibliotheque.repository.ExemplaireRepository;
import com.bibliotheque.repository.LivreRepository;
import com.bibliotheque.repository.UtilisateurRepository;
import com.bibliotheque.service.LivreService;
import com.bibliotheque.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LivreServiceImpl implements LivreService {

    public static final int PERIODE_PROLONGEE_DE_PRET = 60;
    private static final int PERIODE_INITIALE_DE_PRET = 30;

    @Autowired
    LivreRepository livreRepository;

    @Autowired
    ExemplaireRepository exemplaireRepository;

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Override
    public List<Livre> rechercherTousLesLivres() {
        return livreRepository.findAll();
    }

    @Override
    public Livre findById(Integer id) {
        Optional<Livre> optionalLivre = livreRepository.findById(id);
        if (optionalLivre.isPresent()) {
            return optionalLivre.get();
        }
        return null;
    }

    @Override
    public List<Livre> rechercherParAuteurOuTitre(String motCle) {

        String motCleRecherche = "%" + motCle + "%";
        List<Livre> livreList = livreRepository.rechercherParAuteurOuTitre(motCleRecherche);

        return livreList;
    }


    @Override
    public List<Livre> rechercherTousLesLivresPourUtilisateur(int id) {
        List<Livre> livres = livreRepository.rechercherTousLesLivresPourUtilisateur(id);
        for (Livre livre : livres) {
            for (Exemplaire exemplaire : livre.getExemplaireList()) {
                calculerDateRetour(exemplaire);
            }
        }
        return livres;
    }

//    @Override
//    public List<Exemplaire> rechercherTousLesExemplairesPourUtilisateur(int utilisateurId) {
//        List<Exemplaire> exemplaires = livreRepository.rechercherTousLesExemplairesPourUtilisateur(utilisateurId);
//        for (Exemplaire exemplaire : exemplaires) {
//
//                calculerDateRetour(exemplaire);
//            }
//        return exemplaires;
//    }


    private void calculerDateRetour(Exemplaire exemplaire) {
        if (exemplaire.isProlongerEmprunt()) {
            exemplaire.setDateRetour(exemplaire.getDateDemprunt().plusDays(PERIODE_PROLONGEE_DE_PRET));
        } else {
            exemplaire.setDateRetour(exemplaire.getDateDemprunt().plusDays(PERIODE_INITIALE_DE_PRET));
        }

    }

    @Override
    public Exemplaire prolongerEmPrunt(int exemplaireId) {

        Exemplaire exemplaire = exemplaireRepository.findById(exemplaireId).get();
        exemplaire.setProlongerEmprunt(true);
        exemplaireRepository.save(exemplaire);
        calculerDateRetour(exemplaire);

        return exemplaire;
    }


    // -------------------------------------------- PARTIE RESERVE AU PERSONNEL -------------------------------------


    @Override
    public Exemplaire creerEmprunt(int exemplaireId, int utilisateurId) {
        Exemplaire exemplaire = exemplaireRepository.findById(exemplaireId).get();
        exemplaire.setPret(true);
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId).get();
        exemplaire.setUtilisateur(utilisateur);
        exemplaire.setDateDemprunt(LocalDate.now());
        exemplaireRepository.save(exemplaire);
        return exemplaire;
    }

    @Override
    public Exemplaire retourEmprunt(Integer exemplaireId) {
        Exemplaire exemplaire = exemplaireRepository.findById(exemplaireId).get();
        exemplaire.setPret(false);
        exemplaire.setUtilisateur(null);
        exemplaire.setDateDemprunt(null);
        exemplaireRepository.save(exemplaire);
        return exemplaire;
    }


}
