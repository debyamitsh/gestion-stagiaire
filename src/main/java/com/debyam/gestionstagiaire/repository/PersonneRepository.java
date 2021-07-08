package com.debyam.gestionstagiaire.repository;

import com.debyam.gestionstagiaire.entity.Personne;
import org.springframework.data.repository.CrudRepository;

public interface PersonneRepository extends CrudRepository<Personne, Long> {
}
