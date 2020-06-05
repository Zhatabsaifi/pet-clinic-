package zhatab.springframework.petclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person{
    private Set<Speciality> specialitySet = new HashSet<>();// good to assign at initalize time // reduce the chance of exception whe you not insert anything and try to get function


    public Set<Speciality> getSpecialitySet() {
        return specialitySet;
    }

    public void setSpecialitySet(Set<Speciality> specialitySet) {
        this.specialitySet = specialitySet;
    }
}
