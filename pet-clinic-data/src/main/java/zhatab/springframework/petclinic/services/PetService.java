package zhatab.springframework.petclinic.services;

import zhatab.springframework.petclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long is);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
