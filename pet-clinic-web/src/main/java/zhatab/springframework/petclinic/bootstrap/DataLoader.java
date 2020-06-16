package zhatab.springframework.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import zhatab.springframework.petclinic.model.*;
import zhatab.springframework.petclinic.services.*;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count =  petTypeService.findAll().size();
        if(count == 0){
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality saveRadioogy = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality saveSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality saveDentistry = specialityService.save(dentistry);

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

        Visit catVisit = new Visit();
        catVisit.setPet(aftabCat);
        catVisit.setDate(LocalDate.now());

        visitService.save(catVisit);

        System.out.println("Loaded Owners.....");


        Vet vet1 = new Vet();
        vet1.setFirstName("Detective ");
        vet1.setLastName("Decker");
        vet1.getSpecialities().add(saveRadioogy);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Lucifer");
        vet2.setLastName("Morning star");
        vet2.getSpecialities().add(saveDentistry);
        vetService.save(vet2);

        System.out.println("Loaded vets....");
    }
}
