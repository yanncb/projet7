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

    List<Livre> findByTitre(String titre);
    Livre findByAuteur(String auteur);

    @Query("select l from Livre l where l.auteur like :motCle or l.titre like :motCle")
    List<Livre> rechercherParAuteurOuTitre(@Param("motCle") String motCle);

//    @Query("SELECT l from Livre l join Utilisateur u on u.utilisateurId = l.utilisateur where u.nom = :nom")
//    Optional<Livre> rechercherTousLesLivresEmprunteParUtilisateur(@Param("nom")String nom);

}
