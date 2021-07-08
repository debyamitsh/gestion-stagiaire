package com.debyam.gestionstagiaire.entity;

import javax.persistence.Entity;

@Entity
public class Coordonateur extends Personne{
    private String matriculeCoordonateur;
    private String titreAcademic;
    private String specialite;

    public Coordonateur() {
    }

    public String getMatriculeCoordonateur() {
        return matriculeCoordonateur;
    }

    public void setMatriculeCoordonateur(String matriculeCoordonateur) {
        this.matriculeCoordonateur = matriculeCoordonateur;
    }

    public String getTitreAcademic() {
        return titreAcademic;
    }

    public void setTitreAcademic(String titreAcademic) {
        this.titreAcademic = titreAcademic;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
}
