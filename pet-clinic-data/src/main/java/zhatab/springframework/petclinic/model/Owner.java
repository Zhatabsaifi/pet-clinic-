package zhatab.springframework.petclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Owner extends Person{
    private  String address,city,telephone;
    private Set<Pet> pets = new HashSet<>();   // good to assign at initalize time // reduce the chance of exception whe you not insert anything and try to get function

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
