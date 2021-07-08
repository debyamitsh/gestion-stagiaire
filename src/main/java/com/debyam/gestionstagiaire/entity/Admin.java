package com.debyam.gestionstagiaire.entity;

import javax.persistence.Entity;

@Entity
public class Admin extends Personne{
    private String matriculeAdmin;

    public Admin() {
    }

    public String getMatriculeAdmin() {
        return matriculeAdmin;
    }

    public void setMatriculeAdmin(String matriculeAdmin) {
        this.matriculeAdmin = matriculeAdmin;
    }
}
