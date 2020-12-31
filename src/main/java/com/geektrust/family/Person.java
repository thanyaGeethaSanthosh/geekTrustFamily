package com.geektrust.family;

import com.geektrust.constants.Gender;
import com.geektrust.constants.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public List<Person> findPaternalUncles() {
        List<Person> siblingsOfFather = this.mother.partner.findSiblings();
        return siblingsOfFather.stream().filter(person -> !person.isFemale()).collect(Collectors.toList());
    }

    public List<Person> findPaternalAunts() {
        List<Person> siblingsOfFather = this.mother.partner.findSiblings();
        return siblingsOfFather.stream().filter(Person::isFemale).collect(Collectors.toList());
    }

    public List<Person> findMaternalUncles() {
        List<Person> siblingsOfMother = this.mother.findSiblings();
        return siblingsOfMother.stream().filter(person -> !person.isFemale()).collect(Collectors.toList());
    }

    public List<Person> findMaternalAunts() {
        List<Person> siblingsOfMother = this.mother.findSiblings();
        return siblingsOfMother.stream().filter(Person::isFemale).collect(Collectors.toList());
    }

    public List<Person> findBrothersInLaw() {
        ArrayList<Person> brothersInLaw = new ArrayList<>();
        Stream<Person> marriedSisters = this.findSisters().stream().filter(person -> person.partner != null);
        List<Person> husbandsOfSisters = marriedSisters.map(person -> person.partner).collect(Collectors.toList());
        if (this.partner != null) {
            List<Person> brothersOfPartner = this.partner.findBrother();
            brothersInLaw.addAll(brothersOfPartner);
        }

        brothersInLaw.addAll(husbandsOfSisters);
        return brothersInLaw;
    }

    private List<Person> findBrother() {
        if (this.mother == null) {
            return new ArrayList<>();
        }
        List<Person> sonsOfMother = this.mother.findSons();
        return sonsOfMother.stream().filter(child -> !child.isNameMatch(this.name)).collect(Collectors.toList());
    }

    private List<Person> findSisters() {
        if (this.mother == null) {
            return new ArrayList<>();
        }
        List<Person> daughtersOfMother = this.mother.findDaughters();
        return daughtersOfMother.stream().filter(child -> !child.isNameMatch(this.name)).collect(Collectors.toList());
    }

    public List<Person> findSistersInLaw() {
        ArrayList<Person> sistersInLaw = new ArrayList<>();
        Stream<Person> marriedBrothers = this.findBrother().stream().filter(person -> person.partner != null);
        List<Person> wivesOfBrothers = marriedBrothers.map(person -> person.partner).collect(Collectors.toList());
        if (this.partner != null) {
            List<Person> sistersOfPartner = this.partner.findSisters();
            sistersInLaw.addAll(sistersOfPartner);
        }

        sistersInLaw.addAll(wivesOfBrothers);
        return sistersInLaw;
    }

    @Override
    public String toString() {
        return  this.name;
    }
}
