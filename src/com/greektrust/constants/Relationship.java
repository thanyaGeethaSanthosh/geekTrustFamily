package com.greektrust.constants;

import com.greektrust.structure.Person;

import java.util.List;

public enum Relationship {
    DAUGHTER() {
        @Override
        public List<Person> findRelatives(Person person) {
            return person.findDaughters();
        }
    }, SON {
        @Override
        public List<Person> findRelatives(Person person) {
            return person.findSons();
        }
    }, SIBLING {
        @Override
        public List<Person> findRelatives(Person person) {
            return person.findSiblings();
        }
    }, PATERNAL_UNCLE {
        @Override
        public List<Person> findRelatives(Person person) {
            return person.findPaternalUncles();
        }
    }, PATERNAL_AUNT {
        @Override
        public List<Person> findRelatives(Person person) {
            return person.findPaternalAunts();
        }
    }, MATERNAL_UNCLE {
        @Override
        public List<Person> findRelatives(Person person) {
            return person.findMaternalUncles();
        }
    }, MATERNAL_AUNT {
        @Override
        public List<Person> findRelatives(Person person) {
            return person.findMaternalAunts();
        }
    }, BROTHER_IN_LAW {
        @Override
        public List<Person> findRelatives(Person person) {
            return person.findBrothersInLaw();
        }
    }, SISTER_IN_LAW {
        @Override
        public List<Person> findRelatives(Person person) {
            return person.findSistersInLaw();
        }
    };

    public abstract List<Person> findRelatives(Person person);
}
