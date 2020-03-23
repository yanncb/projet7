package com.bibliotheque.service.impl;

import com.bibliotheque.models.Role;
import com.bibliotheque.models.Utilisateur;
import com.bibliotheque.repository.RoleRepository;
import com.bibliotheque.repository.UtilisateurRepository;
import com.bibliotheque.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Utilisateur> rechercherTousLesUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    @Override
    public void ajouterUtilisateur(Utilisateur utilisateur) {
        utilisateur.setMotDePasse(utilisateur.getMotDePasse());
        Role utilisateurRole = roleRepository.findByRolNom("MEMBRE");
        utilisateur.setRoles(new ArrayList<Role>(Arrays.asList(utilisateurRole)));
        utilisateurRepository.save(utilisateur);
    }
}
