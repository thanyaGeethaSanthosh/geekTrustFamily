package com.greektrust.structure;

import com.greektrust.constants.Gender;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class PersonTest {
    @Test
    public void isNameMatchShouldSayTrueWhenGivenNameMatchesWhenPersonIsMale() {
        Person person = new Person("Shan", Gender.MALE);
        assertTrue(person.isNameMatch("Shan"));
    }

    @Test
    public void isNameMatchShouldSayTrueWhenGivenNameMatchesWhenPersonIsFemale() {
        Person person = new Person("Anga",Gender.FEMALE);
        assertTrue(person.isNameMatch("Anga"));
    }

    @Test
    public void isNameMatchShouldSayFalseWhenGivenNameDoesNotMatchesWhenPersonIsMale() {
        Person person = new Person("Shan",Gender.MALE);
        assertFalse(person.isNameMatch("Anga"));
    }

    @Test
    public void isNameMatchShouldSayFalseWhenGivenNameDoesNotMatchesWhenPersonIsFemale() {
        Person person = new Person("Anga",Gender.FEMALE);
        assertFalse(person.isNameMatch("Shan"));
    }

    @Test
    public void isPartnerNameMatchShouldSayTrueWhenGivenNameMatchesWithPartnerNameWhenPersonIsMale() {
        Person person = new Person("Shan",Gender.MALE);
        person.addPartner(new Person( "Anga",Gender.FEMALE));
        assertTrue(person.isPartnerNameMatch("Anga"));
    }
    @Test
    public void isPartnerNameMatchShouldSayTrueWhenGivenNameMatchesWithPartnerNameWhenPersonIsFemale() {
        Person person = new Person("Anga",Gender.FEMALE);
        person.addPartner(new Person("Shan",Gender.MALE));
        assertTrue(person.isPartnerNameMatch("Shan"));
    }

    @Test
    public void isPartnerNameMatchShouldSayFalseWhenGivenNameNotMatchesWithPartnerNameWhenPersonIsMale() {
        Person person = new Person("Shan",Gender.MALE);
        person.addPartner(new Person( "Anga",Gender.FEMALE));
        assertFalse(person.isPartnerNameMatch("Vich"));
    }

    @Test
    public void isPartnerNameMatchShouldSayShouldSayFalseWhenGivenNameDoesNotMatchesWithPartnerNameWhenPersonIsFemale() {
        Person person = new Person("Anga",Gender.FEMALE);
        person.addPartner(new Person("Shan",Gender.MALE));
        assertFalse(person.isPartnerNameMatch("Vich"));
    }

    @Test
    public void isChildPresentShouldSayTrueWhenChildIsPresent() {
        Person person = new Person("Shan",Gender.MALE);
        person.addChild(new Person("Vich", Gender.MALE));
        person.addChild(new Person("Ish",Gender.MALE));
        assertTrue(person.isChildPresent("Ish"));
    }

    @Test
    public void isChildPresentShouldSayFalseWhenChildIsNotPresent() {
        Person person = new Person("Shan",Gender.MALE);
        person.addChild(new Person("Vich",Gender.MALE));
        person.addChild(new Person("Ish",Gender.MALE));
        assertFalse(person.isChildPresent("Anga"));
    }

    @Test
    public void findPersonShouldFindThePersonWithGivenNameWhenItsKingItselfAndGiveThatPerson() {
        Person person = new Person("Shan",Gender.MALE);
        person.addPartner(new Person("Anga",Gender.FEMALE));


        assertEquals(person,person.findPerson("Shan"));
    }

    @Test
    public void findPersonShouldFindThePersonWithGivenNameWhenItsQueenItselfAndGiveThatPerson() {
        Person person = new Person("Shan",Gender.MALE);
        Person partner = new Person( "Anga", Gender.FEMALE);
        person.addPartner(partner);

        assertEquals(partner, person.findPerson("Anga"));
    }

    @Test
    public void findPersonShouldFindThePersonWithGivenNameWhenItsOneOfKingsChildAndGiveThatPerson() {
        Person person = new Person("Shan",Gender.MALE);
        person.addPartner(new Person("Anga",Gender.FEMALE));
        person.addChild(new Person("Vich",Gender.MALE));
        Person ish = new Person("Ish",Gender.MALE);
        person.addChild(ish);


        assertEquals(ish, person.findPerson("Ish"));
    }
}
