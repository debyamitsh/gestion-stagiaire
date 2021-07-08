package com.debyam.gestionstagiaire.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Carnet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long numeroCarnet;
    @OneToMany
    private List<PageCarnet> pages;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumeroCarnet() {
        return numeroCarnet;
    }

    public void setNumeroCarnet(Long numeroCarnet) {
        this.numeroCarnet = numeroCarnet;
    }

    public List<PageCarnet> getPages() {
        return pages;
    }

    public void setPages(List<PageCarnet> pages) {
        this.pages = pages;
    }
}
