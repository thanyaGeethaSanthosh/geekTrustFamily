package com.greektrust.structure;

import com.greektrust.constants.Relationship;
import com.greektrust.constants.Status;

import java.util.ArrayList;
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
        List<Person> relatives;
        switch (relation) {
            case SON:
                relatives = person.findSons();
                break;
            case DAUGHTER:
                relatives = person.findDaughters();
                break;
            case SIBLING:
                relatives = person.findSiblings();
                break;
            case PATERNAL_UNCLE:
                relatives = person.findPaternalUncles();
                break;
            case PATERNAL_AUNT:
                relatives = person.findPaternalAunts();
                break;
            default:
                relatives = new ArrayList<>();
        }
        return relatives;
    }
}
