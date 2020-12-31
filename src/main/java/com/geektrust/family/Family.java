package com.geektrust.family;

import com.geektrust.constants.Relationship;
import com.geektrust.constants.Status;

import java.util.List;

public class Family {
    private final Person familyHead;

    public Family(Person familyHead) {
        this.familyHead = familyHead;
    }

    public Status addChild(String motherName, Person child) {
        Person mother = this.familyHead.findPerson(motherName);
        if (mother == null) {
            return Status.PERSON_NOT_FOUND;
        }
        return mother.addChild(child);
    }

    public void addPartner(String oldMemberName, Person partner) {
        Person member = this.familyHead.findPerson(oldMemberName);
        member.addPartner(partner);
    }

    public List<Person> findRelatives(String personName, Relationship relation) {
        Person person = this.familyHead.findPerson(personName);
        return relation.findRelatives(person);
    }
}
