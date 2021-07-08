package com.debyam.gestionstagiaire.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Affectation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dateAffect;
    private Date heureDebut;
    private Date heureFin;

    public Affectation(Long id, Date dateAffect, Date heureDebut, Date heureFin) {
        this.id = id;
        this.dateAffect = dateAffect;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }

    public Affectation() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateAffect() {
        return dateAffect;
    }

    public void setDateAffect(Date dateAffect) {
        this.dateAffect = dateAffect;
    }

    public Date getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(Date heureDebut) {
        this.heureDebut = heureDebut;
    }

    public Date getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(Date heureFin) {
        this.heureFin = heureFin;
    }
}
