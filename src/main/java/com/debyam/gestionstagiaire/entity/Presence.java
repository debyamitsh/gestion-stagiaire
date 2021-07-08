package com.debyam.gestionstagiaire.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Presence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date journee;
    private Date arrivee;
    private Date sortie;

    public Presence() {
    }

    public Presence(Long id, Date journee, Date arrivee, Date sortie) {
        this.id = id;
        this.journee = journee;
        this.arrivee = arrivee;
        this.sortie = sortie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getJournee() {
        return journee;
    }

    public void setJournee(Date journee) {
        this.journee = journee;
    }

    public Date getArrivee() {
        return arrivee;
    }

    public void setArrivee(Date arrivee) {
        this.arrivee = arrivee;
    }

    public Date getSortie() {
        return sortie;
    }

    public void setSortie(Date sortie) {
        this.sortie = sortie;
    }
}
