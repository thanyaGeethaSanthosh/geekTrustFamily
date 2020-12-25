package com.greektrust.structure;

import java.util.Objects;

public class Person {
    private final String name;
    private Women mother = null;
    private Women partner = null;

    public Person(String name,Women mother) {
        this.name = name;
        this.mother = mother;
    }

    public Person(Women partner,String name) {
        this.partner = partner;
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(partner, person.partner);
    }

    public void addPartner(String  partnerName) {
       this.partner=new Women(this,partnerName);
    }

    public boolean isNameMatch(String name) {
        return this.name.equals(name);
    }

    public boolean isPartnerNameMatch(String name) {
        return this.partner.isNameMatch(name);
    }
}
