package zhatab.springframework.petclinic.services.map;

import zhatab.springframework.petclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
    protected Map<Long,T>  map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }
    T findById(ID id){
        return map.get(id);
    }
    T save(T object){

        if(object != null){
            if(object.getId() == null){
                object.setId(getNextId());
            }
            map.put(object.getId(),object);
        }else{
            throw new RuntimeException("Object cannot be null");   // trow exception
        }
        return object;
    }
    void deleteById(ID id){
        map.remove(id);
    }
    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
        // delete those object which value is equal to object
    }

    private Long getNextId(){
        Long nextId=1L;
        if(map.size() != 0){
            nextId += Collections.max(map.keySet()) ;
        }
        return nextId;
    }
}
