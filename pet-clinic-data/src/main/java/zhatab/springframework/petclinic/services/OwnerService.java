package zhatab.springframework.petclinic.services;

import zhatab.springframework.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long>{
    Owner findByLastName(String lastName);
}
