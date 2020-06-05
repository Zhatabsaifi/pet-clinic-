package zhatab.springframework.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import zhatab.springframework.petclinic.model.Owner;
import zhatab.springframework.petclinic.model.Pet;
import zhatab.springframework.petclinic.model.PetType;
import zhatab.springframework.petclinic.model.Vet;
import zhatab.springframework.petclinic.services.OwnerService;
import zhatab.springframework.petclinic.services.PetTypeService;
import zhatab.springframework.petclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Zhatab");
        owner1.setLastName("Saifi");
        owner1.setAddress("Badsha nagar ");
        owner1.setCity("Dadri");
        owner1.setTelephone("8010311757");

        Pet zhatabPet = new Pet();
        zhatabPet.setPetType(saveDogPetType);
        zhatabPet.setOwner(owner1);
        zhatabPet.setBirthDate(LocalDate.now());
        zhatabPet.setName("Rocky");
        owner1.getPets().add(zhatabPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Aftab");
        owner2.setLastName("Saifi");
        owner2.setAddress("Bada Bazar ");
        owner2.setCity("Dadri");
        owner2.setTelephone("8278935754");


        Pet aftabCat = new Pet();
        aftabCat.setPetType(saveCatPetType);
        aftabCat.setOwner(owner2);
        aftabCat.setBirthDate(LocalDate.now());
        aftabCat.setName("Tillu");
        owner2.getPets().add(aftabCat);

        ownerService.save(owner2);

        System.out.println("Loaded Owners.....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Detective ");
        vet1.setLastName("Decker");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Lucifer");
        vet2.setLastName("Morning star");
        vetService.save(vet2);

        System.out.println("Loaded vets....");
    }
}
