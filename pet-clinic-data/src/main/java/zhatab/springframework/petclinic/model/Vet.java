package zhatab.springframework.petclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person{

    // good to assign at initalize time // reduce the chance of exception whe you not insert anything and try to get function
    private Set<Speciality> specialities = new HashSet<>();

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
