package com.geektrust.family;

import com.geektrust.constants.ChildAdditionStatus;
import com.geektrust.constants.Relationship;
import com.geektrust.exceptions.PersonNotFountException;

import java.util.List;

public class Family {
    private final Person familyHead;

    public Family(Person familyHead) {
        this.familyHead = familyHead;
    }

    public ChildAdditionStatus addChild(String motherName, Person child) throws PersonNotFountException {
        Person mother = this.familyHead.findPerson(motherName);
        if (mother == null) {
            throw new PersonNotFountException();
        }
        return mother.addChild(child);
    }

    public void addPartner(String oldMemberName, Person partner) {
        Person member = this.familyHead.findPerson(oldMemberName);
        member.addPartner(partner);
    }

    public List<Person> findRelatives(String personName, Relationship relation) throws PersonNotFountException {
        Person person = this.familyHead.findPerson(personName);
        if (person == null) {
            throw new PersonNotFountException();
        }
        return relation.findRelatives(person);
    }
}
