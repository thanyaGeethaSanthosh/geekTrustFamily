package com.greektrust.structure;

import com.greektrust.exceptions.PersonNotFountException;

import java.util.ArrayList;

public class Members {
    private final ArrayList<Person> members;

    public Members() {
        this.members = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Members members = (Members) o;
        return this.members.equals(members.members);
    }

    public void addAll(Members list) {
        this.members.addAll(list.members);
    }

    public void add(Person child) {
        this.members.add(child);
    }

    public boolean isChildPresent(String childName) {
        for (Person person : this.members) {
            if (person.isNameMatch(childName)) {
                return true;
            }
        }
        return false;
    }

    public Person findChild(String childName) throws PersonNotFountException {
        for (Person person : this.members) {
            if (person.isNameMatch(childName)) {
                return person;
            }
        }
        throw new PersonNotFountException();
    }

    public Person findPerson(String name){
        for (Person person : this.members) {
            if (person.isNameMatch(name)) {
                return person;
            }
            Person person1 = person.findPerson(name);
            if (person1!=null){
                return person1;
            }

        }
        return null;
    }

}
