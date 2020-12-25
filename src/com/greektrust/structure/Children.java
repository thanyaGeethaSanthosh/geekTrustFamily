package com.greektrust.structure;

import com.greektrust.exceptions.PersonNotFountException;

import java.util.ArrayList;

public class Children {
    private final ArrayList<Person> people;

    public Children() {
        this.people = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Children children = (Children) o;
        return people.equals(children.people);
    }

    public void addAll(Children list) {
        this.people.addAll(list.people);
    }

    public void add(Person child) {
        this.people.add(child);
    }

    public boolean isChildPresent(String childName) {
        for (Person person : this.people) {
            if (person.isNameMatch(childName)) {
                return true;
            }
        }
        return false;
    }

    public Person findChild(String childName) throws PersonNotFountException {
        for (Person person : this.people) {
            if (person.isNameMatch(childName)) {
                return person;
            }
        }
        throw new PersonNotFountException();
    }

}
