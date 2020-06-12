package zhatab.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import zhatab.springframework.petclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
