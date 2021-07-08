package com.debyam.gestionstagiaire.controller;

import com.debyam.gestionstagiaire.entity.Coordonateur;
import com.debyam.gestionstagiaire.error.ResourceNotFoundException;
import com.debyam.gestionstagiaire.repository.CoordonateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CoordonateurController {
    @Autowired
    private CoordonateurRepository coordonateurRepository;

    @GetMapping("/coordonateurs")
    public Iterable<Coordonateur> getAllCoordonateur() {
        return coordonateurRepository.findAll();
    }

    @PostMapping("/coordonateurs")
    public Coordonateur createCoordonateurs(@Validated @RequestBody Coordonateur coordonateur) {
        return  coordonateurRepository.save(coordonateur);
    }

    @PutMapping("/coordonateurs/{id}")
    public ResponseEntity<Coordonateur> updateCoordonateur(@PathVariable(value = "id") Long coordonateurId,
                                             @Validated @RequestBody Coordonateur coordonateurdetails) throws ResourceNotFoundException {
        Coordonateur coordonateur = coordonateurRepository.findById(coordonateurId)
                .orElseThrow(() -> new ResourceNotFoundException("coordonateur pas trouver"));
        coordonateur.setNom(coordonateurdetails.getNom());
        coordonateur.setPostNom(coordonateurdetails.getPostNom());
        coordonateur.setPrenom(coordonateurdetails.getPrenom());
        coordonateur.setDateNaissance(coordonateurdetails.getDateNaissance());
        coordonateur.setGenre(coordonateurdetails.getGenre());
        coordonateur.setTelephone(coordonateurdetails.getTelephone());
        coordonateur.setEmail(coordonateurdetails.getEmail());
        coordonateur.setMatriculeCoordonateur(coordonateurdetails.getMatriculeCoordonateur());
        coordonateur.setTitreAcademic(coordonateurdetails.getTitreAcademic());
        coordonateur.setSpecialite(coordonateurdetails.getSpecialite());

        final Coordonateur updateCoordonateur = coordonateurRepository.save(coordonateur);

        return ResponseEntity.ok(updateCoordonateur);
    }

    @DeleteMapping("/coordonateurs/{id}")
    public Map<String, Boolean> deleteCoordonateur(
            @PathVariable(value = "id") Long coordonateurId
    ) throws ResourceNotFoundException {
        Coordonateur coordonateur = coordonateurRepository.findById(coordonateurId)
                .orElseThrow(() -> new ResourceNotFoundException("coordonateur not find"));
        coordonateurRepository.delete(coordonateur);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
