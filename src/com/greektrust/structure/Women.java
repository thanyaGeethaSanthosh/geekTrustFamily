package com.greektrust.structure;

import com.greektrust.constants.Gender;

import java.util.ArrayList;

public class Women extends Person {
    private final ArrayList<Person> children;
    private Person partner;

    public Women(String name) {
        super(name);
        this.children = new ArrayList<>();
    }

    public Women(Person partner, String name) {
        super(name);
        this.partner = partner;
        this.children = new ArrayList<>();
    }

    public Women(String name, Women mother) {
        super(name, mother);
        this.children = new ArrayList<>();
    }

    public void addPartner(String partnerName) {
        this.partner = new Person(this, partnerName);
    }

    public void addChild(String name, Gender gender) {
        if (gender == Gender.FEMALE) {
            this.children.add(new Women(name, this));
        } else {
            this.children.add(new Person(name, this));
        }
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

    @Override
    public boolean isPartnerNameMatch(String name) {
        return this.partner.isNameMatch(name);
    }

    @Override
    public Person findPerson(String name) {
        if (this.isNameMatch(name)) {
            return this;
        }
        if (this.isPartnerNameMatch(name)) {
            return this.partner;
        }
        return this.findChild(name);
    }
}
