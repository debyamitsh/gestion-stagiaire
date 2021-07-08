package com.debyam.gestionstagiaire.repository;

import com.debyam.gestionstagiaire.entity.Utilisateur;
import org.springframework.data.repository.CrudRepository;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {
}
