package com.bibliotheque.repository;

import com.bibliotheque.models.Exemplaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExemplaireRepository extends JpaRepository<Exemplaire, Integer> {

    @Query("select e from Exemplaire e join Utilisateur u on u.id = e.utilisateur WHERE u.id = :id")
    List<Exemplaire> rechercherTousLesToposPourUtilisateur(@Param("id") int id);
}
