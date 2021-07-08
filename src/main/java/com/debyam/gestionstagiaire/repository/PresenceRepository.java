package com.debyam.gestionstagiaire.repository;

import com.debyam.gestionstagiaire.entity.Presence;
import org.springframework.data.repository.CrudRepository;

public interface PresenceRepository extends CrudRepository<Presence, Long> {
}
