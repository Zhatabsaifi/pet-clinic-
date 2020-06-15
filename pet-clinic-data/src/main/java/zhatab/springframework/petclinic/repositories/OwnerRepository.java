package zhatab.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import zhatab.springframework.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
    Owner findByLastName(String lastName);
}
