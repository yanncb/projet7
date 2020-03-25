package com.bibliotheque.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_exemplaire")
public class Exemplaire {

    @Id
    @SequenceGenerator(name = "T_EXEMPLAIRE_SEQ_GENERATOR", sequenceName = "T_EXEMPLAIRE_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "T_EXEMPLAIRE_SEQ_GENERATOR")
    @Column(name = "exemplaire_id")
    private int id;

    @Column(name = "exemplaire_pret")
    private boolean pret;

    @Column(name = "exemplaire_date_emprunt")
    private Date dateDemprunt;

    @Column(name = "exemplaire_prolongation")
    private boolean prolongerEmprunt;

    @Column(name = "exemplaire_nb_dispo")
    private int nbDispo;

    @ManyToOne
    @JoinColumn(name = "livre_id", nullable = false)
    private Livre livre;

    @ManyToOne
    @JoinColumn(name = "bibli_id", nullable = false)
    private Bibliotheque bibliotheque;

    @ManyToOne
    @JoinColumn(name = "util_id", nullable = false)
    private Utilisateur utilisateur;

    public Exemplaire() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPret() {
        return pret;
    }

    public void setPret(boolean pret) {
        this.pret = pret;
    }

    public Date getDateDemprunt() {
        return dateDemprunt;
    }

    public void setDateDemprunt(Date dateDemprunt) {
        this.dateDemprunt = dateDemprunt;
    }

    public boolean isProlongerEmprunt() {
        return prolongerEmprunt;
    }

    public void setProlongerEmprunt(boolean prolongerEmprunt) {
        this.prolongerEmprunt = prolongerEmprunt;
    }

    public int getNbDispo() {
        return nbDispo;
    }

    public void setNbDispo(int nbDispo) {
        this.nbDispo = nbDispo;
    }

    @Override
    public String toString() {
        return "Exemplaire{" +
                "id=" + id +
                ", pret=" + pret +
                ", dateDemprunt=" + dateDemprunt +
                ", prolongerEmprunt=" + prolongerEmprunt +
                ", nbDispo=" + nbDispo +
                '}';
    }
}
