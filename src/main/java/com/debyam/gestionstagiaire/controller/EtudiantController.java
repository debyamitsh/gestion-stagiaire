package com.debyam.gestionstagiaire.controller;

import com.debyam.gestionstagiaire.entity.Etudiant;
import com.debyam.gestionstagiaire.error.ResourceNotFoundException;
import com.debyam.gestionstagiaire.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class EtudiantController {
    @Autowired
    private EtudiantRepository etudiantRepository;

    @GetMapping("/etudiants")
    public Iterable<Etudiant> getAllEtudiant() {
        return etudiantRepository.findAll();
    }


    @PostMapping("/etudiants")
    public Etudiant createEtudiant(@Validated @RequestBody Etudiant etudiant) {
        return  etudiantRepository.save(etudiant);
    }

    @PutMapping("/etudiants/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable(value = "id") Long etudiantId,
                                                   @Validated @RequestBody Etudiant etudiantdetails) throws ResourceNotFoundException {
        Etudiant etudiant = etudiantRepository.findById(etudiantId)
                .orElseThrow(() -> new ResourceNotFoundException("etudiant pas trouver"));
        etudiant.setNom(etudiantdetails.getNom());
        etudiant.setPostNom(etudiantdetails.getPostNom());
        etudiant.setPrenom(etudiantdetails.getPrenom());
        etudiant.setDateNaissance(etudiantdetails.getDateNaissance());
        etudiant.setGenre(etudiantdetails.getGenre());
        etudiant.setTelephone(etudiantdetails.getTelephone());
        etudiant.setEmail(etudiantdetails.getEmail());
        etudiant.setMatricule(etudiantdetails.getMatricule());
        etudiant.setFiliere(etudiantdetails.getFiliere());

        final Etudiant updateEtudiant = etudiantRepository.save(etudiant);

        return ResponseEntity.ok(updateEtudiant);
    }

    @DeleteMapping("/etudiants/{id}")
    public Map<String, Boolean> deleteEtudiant(
            @PathVariable(value = "id") Long etudiantId
    ) throws ResourceNotFoundException {
        Etudiant etudiant = etudiantRepository.findById(etudiantId)
                .orElseThrow(() -> new ResourceNotFoundException("etudiant not find"));
        etudiantRepository.delete(etudiant);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
