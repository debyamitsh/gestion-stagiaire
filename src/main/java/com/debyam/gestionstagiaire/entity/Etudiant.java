package com.debyam.gestionstagiaire.entity;

import javax.persistence.Entity;

@Entity
public class Etudiant extends Personne{
    private String matricule;
    private String filiere;

    public Etudiant() {
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }
}
