package com.debyam.gestionstagiaire.controller;

import com.debyam.gestionstagiaire.entity.Maitre;
import com.debyam.gestionstagiaire.error.ResourceNotFoundException;
import com.debyam.gestionstagiaire.repository.MaitreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MaitreController {
    @Autowired
    private MaitreRepository maitreRepository;

    @GetMapping("/maitres")
    public Iterable<Maitre> getAllMaitre() {
        return maitreRepository.findAll();
    }

    @PostMapping("/maitres")
    public Maitre createMaitre(@Validated @RequestBody Maitre maitre) {
        return  maitreRepository.save(maitre);
    }

    @PutMapping("/maitres/{id}")
    public ResponseEntity<Maitre> updateMaitre(@PathVariable(value = "id") Long maitreId,
                                             @Validated @RequestBody Maitre maitredetails) throws ResourceNotFoundException {
        Maitre maitre = maitreRepository.findById(maitreId)
                .orElseThrow(() -> new ResourceNotFoundException("Maitre pas trouver"));
        maitre.setNom(maitredetails.getNom());
        maitre.setPostNom(maitredetails.getPostNom());
        maitre.setPrenom(maitredetails.getPrenom());
        maitre.setDateNaissance(maitredetails.getDateNaissance());
        maitre.setGenre(maitredetails.getGenre());
        maitre.setTelephone(maitredetails.getTelephone());
        maitre.setEmail(maitredetails.getEmail());
        maitre.setMatriculeMaitre(maitredetails.getMatriculeMaitre());
        maitre.setFonction(maitredetails.getFonction());

        final Maitre updateMaitre = maitreRepository.save(maitre);

        return ResponseEntity.ok(updateMaitre);
    }

    @DeleteMapping("/maitres/{id}")
    public Map<String, Boolean> deleteMaitre(
            @PathVariable(value = "id") Long maitreId
    ) throws ResourceNotFoundException {
        Maitre Maitre = maitreRepository.findById(maitreId)
                .orElseThrow(() -> new ResourceNotFoundException("Maitre not find"));
        maitreRepository.delete(Maitre);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
