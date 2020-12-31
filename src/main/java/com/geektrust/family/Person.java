package com.geektrust.family;

import com.geektrust.constants.ChildAdditionStatus;
import com.geektrust.constants.Gender;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
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

    public ChildAdditionStatus addChild(Person child) {
        if (this.gender != Gender.FEMALE) {
            return ChildAdditionStatus.CHILD_ADDITION_FAILED;
        }

        this.children.add(child);
        child.mother = this;
        return ChildAdditionStatus.CHILD_ADDITION_SUCCEEDED;
    }

    public void addPartner(Person partner) {
        this.partner = partner;
        partner.partner = this;
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

    public List<Person> findSons() {
        ArrayList<Person> children = this.getChildren();
        return this.getFilteredList(children, person -> !person.isFemale());
    }


    public List<Person> findDaughters() {
        ArrayList<Person> children = this.getChildren();
        return this.getFilteredList(children, Person::isFemale);
    }

    public List<Person> findSiblings() {
        ArrayList<Person> children = this.mother.getChildren();
        return this.getFilteredList(children, child -> !child.isNameMatch(this.name));
    }

    public List<Person> findPaternalUncles() {
        List<Person> siblingsOfFather = this.mother.partner.findSiblings();
        return this.getFilteredList(siblingsOfFather, person -> !person.isFemale());
    }

    public List<Person> findPaternalAunts() {
        List<Person> siblingsOfFather = this.mother.partner.findSiblings();
        return this.getFilteredList(siblingsOfFather, Person::isFemale);
    }

    public List<Person> findMaternalUncles() {
        List<Person> siblingsOfMother = this.mother.findSiblings();
        return this.getFilteredList(siblingsOfMother, person -> !person.isFemale());
    }

    public List<Person> findMaternalAunts() {
        List<Person> siblingsOfMother = this.mother.findSiblings();
        return this.getFilteredList(siblingsOfMother, Person::isFemale);
    }

    public List<Person> findBrothersInLaw() {
        ArrayList<Person> brothersInLaw = new ArrayList<>();
        Stream<Person> marriedSisters = this.findSisters().stream().filter(Person::isMarried);
        List<Person> husbandsOfSisters = marriedSisters.map(person -> person.partner).collect(Collectors.toList());

        if (this.isMarried()) {
            List<Person> brothersOfPartner = this.partner.findBrothers();
            brothersInLaw.addAll(brothersOfPartner);
        }

        brothersInLaw.addAll(husbandsOfSisters);
        return brothersInLaw;
    }

    public List<Person> findSistersInLaw() {
        ArrayList<Person> sistersInLaw = new ArrayList<>();
        Stream<Person> marriedBrothers = this.findBrothers().stream().filter(Person::isMarried);
        List<Person> wivesOfBrothers = marriedBrothers.map(person -> person.partner).collect(Collectors.toList());

        if (this.isMarried()) {
            List<Person> sistersOfPartner = this.partner.findSisters();
            sistersInLaw.addAll(sistersOfPartner);
        }

        sistersInLaw.addAll(wivesOfBrothers);
        return sistersInLaw;
    }

    public String getName() {
        return this.name;
    }

    private boolean isNameMatch(String name) {
        return this.name.equals(name);
    }

    private boolean isPartner(String name) {
        return this.partner != null && this.partner.name.equals(name);
    }

    private boolean isFemale() {
        return this.gender.isFemale();
    }

    private List<Person> getFilteredList(List<Person> people, Predicate<Person> predicate) {
        return people.stream().filter(predicate).collect(Collectors.toList());
    }

    private List<Person> findSisters() {
        if (this.mother == null) {
            return new ArrayList<>();
        }

        List<Person> siblings = this.findSiblings();
        return this.getFilteredList(siblings, Person::isFemale);
    }

    private List<Person> findBrothers() {
        if (this.mother == null) {
            return new ArrayList<>();
        }

        List<Person> siblings = this.findSiblings();
        return this.getFilteredList(siblings, person -> !person.isFemale());
    }

    private boolean isMarried() {
        return this.partner != null;
    }

    private ArrayList<Person> getChildren() {
        if (!this.isMarried() || this.gender.isFemale()) {
            return this.children;
        }

        return this.partner.children;
    }
}
