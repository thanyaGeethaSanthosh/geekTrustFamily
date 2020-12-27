package com.greektrust.structure;

import com.greektrust.constants.Gender;

import java.util.Objects;

public class Family {
    private final Person parent;

    public Family(String parentName) {
        this.parent = new Person(parentName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(parent, family.parent);
    }

    public void addChild(String motherName, String childName,Gender gender) {
        Women mother = (Women) this.parent.findPerson(motherName);
        mother.addChild(childName, gender);
    }

    public void addPartner(String oldMemberName, String partnerName) {
        Person member = this.parent.findPerson(oldMemberName);
        member.addPartner(partnerName);
    }
}
