package com.greektrust.structure;

import com.greektrust.constants.Gender;
import com.greektrust.constants.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private final String name;
    private final ArrayList<Person> children = new ArrayList<>();
    private final Gender gender;
    private Person mother = null;
    private Person partner = null;

    public Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public boolean isNameMatch(String name) {
        return this.name.equals(name);
    }

    public void addPartner(Person partner) {
        this.partner = partner;
        partner.partner = this;
    }

    public Status addChild(Person child) {
        if (this.gender != Gender.FEMALE) {
            return Status.CHILD_ADDITION_FAILED;
        }
        this.children.add(child);
        child.mother = this;
        return Status.CHILD_ADDITION_SUCCEEDED;
    }

    public boolean isPartner(String name) {
        return this.partner != null && this.partner.name.equals(name);
    }

    public boolean isChildPresent(String name) {
        for (Person person : this.children) {
            if (person.isNameMatch(name)) {
                return true;
            }
        }
        return false;
    }

    public Person findPerson(String name) {
        if (this.isNameMatch(name)) {
            return this;
        }
        if (this.isPartner(name)) {
            return this.partner;
        }

        ArrayList<Person> children = this.getChildren();
        for (Person child : children) {
            Person person = child.findPerson(name);
            if (person != null) {
                return person;
            }
        }
        return null;
    }

    public ArrayList<Person> getChildren() {
        if (this.partner == null || this.gender.isFemale()) {
            return this.children;
        }
        return this.partner.children;
    }

    public boolean isFemale() {
        return this.gender.isFemale();
    }

    public List<Person> findSiblings() {
        ArrayList<Person> children = this.mother.getChildren();
        return children.stream().filter(child -> !child.isNameMatch(this.name)).collect(Collectors.toList());
    }

    public List<Person> findSons() {
        ArrayList<Person> children = this.getChildren();
        return children.stream().filter(person -> !person.isFemale()).collect(Collectors.toList());

    }

    public List<Person> findDaughters() {
        ArrayList<Person> children = this.getChildren();
        return children.stream().filter(Person::isFemale).collect(Collectors.toList());

    }
}
