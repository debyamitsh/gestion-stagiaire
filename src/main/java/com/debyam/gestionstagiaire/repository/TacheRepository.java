package com.debyam.gestionstagiaire.repository;

import com.debyam.gestionstagiaire.entity.Tache;
import org.springframework.data.repository.CrudRepository;

public interface TacheRepository extends CrudRepository<Tache, Long> {
}
