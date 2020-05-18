package zhatab.springframework.petclinic.services;


import zhatab.springframework.petclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long is);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
