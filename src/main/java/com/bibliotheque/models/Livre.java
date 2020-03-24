package com.bibliotheque.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_livre")
public class Livre {

    @Id
    @SequenceGenerator(name = "T_LIVRE_SEQ_GENERATOR", sequenceName = "T_LIVRE_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "T_LIVRE_SEQ_GENERATOR")
    @Column(name = "livre_id")
    private int id;

    @Column(name = "livre_nom")
    private String nom;

    @Column(name = "livre_nb_dispo")
    private int nbDispo;

    @Column(name = "livre_pret")
    private boolean pret;

    @Column(name = "livre_date_emprunt")
    private Date date;

    @Column(name = "livre_prolongation")
    private boolean prolongation;

    @Column(name = "livre_auteur")
    private String auteur;

    public Livre() {
    }

    public Livre(String nom, int nbDispo, boolean pret, Date date, boolean prolongation, String auteur) {
        this.nom = nom;
        this.nbDispo = nbDispo;
        this.pret = pret;
        this.date = date;
        this.prolongation = prolongation;
        this.auteur = auteur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbDispo() {
        return nbDispo;
    }

    public void setNbDispo(int nbDispo) {
        this.nbDispo = nbDispo;
    }

    public boolean isPret() {
        return pret;
    }

    public void setPret(boolean pret) {
        this.pret = pret;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isProlongation() {
        return prolongation;
    }

    public void setProlongation(boolean prolongation) {
        this.prolongation = prolongation;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", nbDispo=" + nbDispo +
                ", pret=" + pret +
                ", date=" + date +
                ", prolongation=" + prolongation +
                ", auteur='" + auteur + '\'' +
                '}';
    }
}
