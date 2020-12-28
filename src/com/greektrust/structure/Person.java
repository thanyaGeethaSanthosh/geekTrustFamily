package com.greektrust.structure;

import com.greektrust.constants.Gender;

import java.util.ArrayList;

public class Person {
    private final String name;
    private final ArrayList<Person> children;
    private final Gender gender;
    private Person mother = null;
    private Person partner = null;

    public Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    public boolean isNameMatch(String name) {
        return this.name.equals(name);
    }

    public void addPartner(Person partner) {
        this.partner = partner;
        partner.partner = this;
    }

    public void addChild(Person child) {
        this.children.add(child);
        child.mother = this;
    }

    public boolean isPartnerNameMatch(String name) {
        return this.partner.name.equals(name);
    }

    public boolean isChildPresent(String name) {
        for (Person person : this.children) {
            if (person.isNameMatch(name)) {
                return true;
            }
        }
        return false;
    }

    public Person findChild(String name) {
        for (Person person : this.children) {
            Person person1 = person.findPerson(name);
            if (person1 != null) {
                return person1;
            }
        }
        return null;
    }

    public Person findPerson(String name) {
        if (this.isNameMatch(name)) {
            return this;
        }
        if (this.partner.isNameMatch(name)) {
            return this.partner;
        }
        return this;
    }
}
