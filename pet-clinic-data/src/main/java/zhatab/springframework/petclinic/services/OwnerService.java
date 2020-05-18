package zhatab.springframework.petclinic.services;

import zhatab.springframework.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findByLastName(String lastName);
    Owner findById(Long is);
    Owner save(Owner owner);
    Set<Owner> findAll();
}
