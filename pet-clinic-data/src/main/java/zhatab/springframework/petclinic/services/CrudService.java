package zhatab.springframework.petclinic.services;

import java.util.Set;

public interface CrudService<T, ID> {
    Set<T> findAll();
    T findById(ID id);
    T save(T oject);
    void delete(T object);
    void deleteById(ID id);
}
