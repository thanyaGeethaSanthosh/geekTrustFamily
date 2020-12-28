package com.greektrust.structure;

import com.greektrust.constants.Gender;

public class Family {
    private final Person parent;

    public Family(String parentName, Gender parentGender) {
        this.parent = new Person(parentName, parentGender);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return parent.equals(family.parent);
    }

    public void addChild(String motherName, String childName, Gender gender) {
        Person mother = this.parent.findPerson(motherName);
        mother.addChild(new Person(childName, gender));
    }

    public void addPartner(String oldMemberName, String partnerName, Gender partnerGender) {
        Person member = this.parent.findPerson(oldMemberName);
        member.addPartner(new Person(partnerName, partnerGender));
    }
}
