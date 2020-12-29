package com.greektrust.structure;

import com.greektrust.constants.Status;

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

    public List<Person> findSons(String name) {
        Person person = this.familyHead.findPerson(name);
        return person.findSons();
    }

    public List<Person> findDaughters(String name) {
        Person person = this.familyHead.findPerson(name);
        return person.findDaughters();
    }

    public List<Person> findSiblings(String name){
        Person person = this.familyHead.findPerson(name);
        return person.findSiblings();
    }
}
