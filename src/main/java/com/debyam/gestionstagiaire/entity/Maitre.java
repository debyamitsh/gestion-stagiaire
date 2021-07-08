package com.debyam.gestionstagiaire.entity;

import javax.persistence.Entity;

@Entity
public class Maitre extends Personne{
    private String matriculeMaitre;
    private String fonction;

    public Maitre(String matriculeMaitre, String fonction) {
        this.matriculeMaitre = matriculeMaitre;
        this.fonction = fonction;
    }

    public Maitre() {

    }

    public String getMatriculeMaitre() {
        return matriculeMaitre;
    }

    public void setMatriculeMaitre(String matriculeMaitre) {
        this.matriculeMaitre = matriculeMaitre;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }
}
