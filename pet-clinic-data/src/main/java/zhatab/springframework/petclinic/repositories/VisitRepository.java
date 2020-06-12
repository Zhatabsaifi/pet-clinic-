package zhatab.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import zhatab.springframework.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
