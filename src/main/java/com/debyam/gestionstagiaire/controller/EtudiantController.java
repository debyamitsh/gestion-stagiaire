package com.debyam.gestionstagiaire.controller;

import com.debyam.gestionstagiaire.entity.Etudiant;
import com.debyam.gestionstagiaire.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EtudiantController {
    @Autowired
    private EtudiantRepository etudiantRepository;

    @PostMapping("/etudiants")
    public Etudiant createEtudiant(@Validated @RequestBody Etudiant etudiant) {
        return  etudiantRepository.save(etudiant);
    }
}
