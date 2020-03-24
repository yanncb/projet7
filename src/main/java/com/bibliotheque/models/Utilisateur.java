package com.bibliotheque.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_utilisateur")
public class Utilisateur {

    @Id
    @SequenceGenerator(name = "T_UTILISATEUR_SEQ_GENERATOR", sequenceName = "T_UTILISATEUR_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "T_UTILISATEUR_SEQ_GENERATOR")
    @Column(name = "util_id")
    private int id;

    @Column(name = "util_nom")
    private String nom;

    @Column(name = "util_prenom")
    private String prenom;

    @Column(name = "util_adresse")
    private String adresse;

    @Column(name = "util_num_tel")
    private String numeroDeTelephone;

    @Column(name = "util_num_carte_bibliotheque")
    private String numCarteBibliotheque;

    @Column(name = "util_mail")
    private String mail;

    @Column(name = "util_mot_de_passe")
    private String motDePasse;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "t_role_utilisateur", joinColumns = @JoinColumn(name = "util_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;


    public Utilisateur() {
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumeroDeTelephone() {
        return numeroDeTelephone;
    }

    public void setNumeroDeTelephone(String numeroDeTelephone) {
        this.numeroDeTelephone = numeroDeTelephone;
    }

    public String getNumCarteBibliotheque() {
        return numCarteBibliotheque;
    }

    public void setNumCarteBibliotheque(String numCarteBibliotheque) {
        this.numCarteBibliotheque = numCarteBibliotheque;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", numeroDeTelephone='" + numeroDeTelephone + '\'' +
                ", numCarteBibliotheque='" + numCarteBibliotheque + '\'' +
                ", mail='" + mail + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                '}';
    }
}
