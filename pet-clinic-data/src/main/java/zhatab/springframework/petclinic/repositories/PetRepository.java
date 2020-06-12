package zhatab.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import zhatab.springframework.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
