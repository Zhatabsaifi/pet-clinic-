package zhatab.springframework.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import zhatab.springframework.petclinic.model.Owner;
import zhatab.springframework.petclinic.model.Vet;
import zhatab.springframework.petclinic.services.OwnerService;
import zhatab.springframework.petclinic.services.VetService;
import zhatab.springframework.petclinic.services.map.OwnerServicMap;
import zhatab.springframework.petclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServicMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Zhatab");
        owner1.setLastName("Saifi");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Aftab");
        owner2.setLastName("Saifi");

        ownerService.save(owner2);

        System.out.println("Loaded Owners.....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Detective ");
        vet1.setLastName("Decker");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Lucifer");
        vet2.setLastName("Morning star");

        vetService.save(vet2);

        System.out.println("Loaded vets....");
    }
}
