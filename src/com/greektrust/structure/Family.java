package com.greektrust.structure;

import com.greektrust.constants.Status;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public List<Person> findSon(String name) {
        Person person = this.familyHead.findPerson(name);
        Stream<Person> personStream = person.getChildren().stream().filter(child -> !child.isFemale());
        return personStream.collect(Collectors.toList());
    }
}
