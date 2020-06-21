package zhatab.springframework.petclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zhatab.springframework.petclinic.model.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    final Long OwnerId = 1L;
    final  String lastName = "saifi";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(),new PetMapService());
        Owner own = new Owner();
        own.setId(OwnerId);
        own.setLastName(lastName);
        ownerMapService.save(own);
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(1,owners.size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(OwnerId);
        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(OwnerId));
        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void saveExistId() {
        Long id = 2L;
        Owner owner2 = new Owner();
        owner2.setId(id);
        Owner saveOwner = ownerMapService.save(owner2);
        assertEquals(id,saveOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner saveOwner = ownerMapService.save(new Owner());
        assertNotNull(saveOwner);
        assertNotNull(saveOwner.getId());
    }

    @Test
    void findById() {
        Owner ow = ownerMapService.findById(OwnerId);
        assertEquals(OwnerId,ow.getId());
    }

    @Test
    void findByLastName() {
        Owner saifi = ownerMapService.findByLastName(lastName);
        assertNotNull(saifi);
        assertEquals(OwnerId,saifi.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner saifi = ownerMapService.findByLastName("zhatab");
        assertNull(saifi);
    }
}