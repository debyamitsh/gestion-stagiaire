package com.debyam.gestionstagiaire.controller;

import com.debyam.gestionstagiaire.entity.Admin;
import com.debyam.gestionstagiaire.error.ResourceNotFoundException;
import com.debyam.gestionstagiaire.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/admins")
    public Iterable<Admin> getAllAdmin() {
        return adminRepository.findAll();
    }

    @PostMapping("/admins")
    public Admin createAdmin(@Validated @RequestBody Admin admin) {
        return  adminRepository.save(admin);
    }

    @PutMapping("/admins/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable(value = "id") Long adminId,
                                                   @Validated @RequestBody Admin admindetails) throws ResourceNotFoundException {
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new ResourceNotFoundException("admin pas trouver"));
        admin.setNom(admindetails.getNom());
        admin.setPostNom(admindetails.getPostNom());
        admin.setPrenom(admindetails.getPrenom());
        admin.setDateNaissance(admindetails.getDateNaissance());
        admin.setGenre(admindetails.getGenre());
        admin.setTelephone(admindetails.getTelephone());
        admin.setEmail(admindetails.getEmail());
        admin.setMatriculeAdmin(admindetails.getMatriculeAdmin());

        final Admin updateadmin = adminRepository.save(admin);

        return ResponseEntity.ok(updateadmin);
    }

    @DeleteMapping("/admins/{id}")
    public Map<String, Boolean> deleteAdmin(
            @PathVariable(value = "id") Long adminId
    ) throws ResourceNotFoundException {
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new ResourceNotFoundException("admin not find"));
        adminRepository.delete(admin);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
