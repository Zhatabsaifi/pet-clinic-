package zhatab.springframework.petclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import zhatab.springframework.petclinic.model.Owner;
import zhatab.springframework.petclinic.model.Pet;
import zhatab.springframework.petclinic.services.OwnerService;
import zhatab.springframework.petclinic.services.PetService;
import zhatab.springframework.petclinic.services.PetTypeService;

import java.util.Set;

@Service
@Profile({"default","map"})
public class OwnerMapService extends AbstractMapService<Owner,Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
       return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }


    @Override
    public void delete(Owner object) {
        super.delete(object);
    }


    @Override
    public Owner save(Owner object) {
        if(object != null){
            if(object.getPets() != null){
                object.getPets().forEach(pet -> {
                    if(pet.getPetType() != null){
                        if(pet.getPetType().getId() == null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }else{
                        throw new RuntimeException("Pet type is required");
                    }
                    if(pet.getId()== null){
                        Pet savedPet = petService.save(pet);   // abstractMApService save method is run
                        // savedPet is used to generate new id which provide to the pet object
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        }else{
            return null;
        }
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll()   //Set<Owner>
                .stream()       // Stream<Owner>
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))      // Stream<Owner>
                .findFirst()    // Optional<Owner>
                .orElse(null);
    }
}
