package com.debyam.gestionstagiaire.repository;

import com.debyam.gestionstagiaire.entity.Etudiant;
import org.springframework.data.repository.CrudRepository;

public interface EtudiantRepository extends CrudRepository<Etudiant, Long> {
}
