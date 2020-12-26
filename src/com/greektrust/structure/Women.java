package com.greektrust.structure;

import com.greektrust.constants.Gender;

public class Women extends Person {
    private final Members members;
    private Person partner;

    public Women(String name) {
        super(name);
        this.members = new Members();
    }

    public Women(Person partner, String name) {
        super(name);
        this.partner = partner;
        this.members = new Members();
    }

    public Women(String name, Women mother) {
        super(name, mother);
        this.members = new Members();
    }

    @Override
    public boolean isPartnerNameMatch(String name) {
        return this.partner.isNameMatch(name);
    }

    public void addPartner(String partnerName) {
        this.partner = new Person(this, partnerName);
    }

    public void addChild(String name, Gender gender) {
        if (gender == Gender.FEMALE) {
            this.members.add(new Women(name, this));
        } else {
            this.members.add(new Person(name, this));
        }
    }

    public boolean isChildPresent(String name) {
        return this.members.isChildPresent(name);
    }

    @Override
    public Person findPerson(String name) {
        if (this.isNameMatch(name)) {
            return this;
        }
        if (this.isPartnerNameMatch(name)) {
            return this.partner;
        }
        return this.members.findPerson(name);
    }
}
