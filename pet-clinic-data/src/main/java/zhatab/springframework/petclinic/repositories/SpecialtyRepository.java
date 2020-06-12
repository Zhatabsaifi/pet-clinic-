package zhatab.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import zhatab.springframework.petclinic.model.Speciality;

public interface SpecialtyRepository extends CrudRepository<Speciality,Long> {
}
