package com.bibliotheque.repository;

import com.bibliotheque.models.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LivreRepository extends JpaRepository<Livre, Integer> {

    List<Livre> findByNom(String nom);
    Livre findByAuteur(String auteur);

    @Query("SELECT l from Livre l join Utilisateur u on u.utilisateurId = l.utilisateur where u.nom = :nom")
    Optional<Livre> rechercherTousLesLivresEmprunteParUtilisateur(@Param("nom")String nom);

}
