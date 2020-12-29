package com.greektrust.structure;

import com.greektrust.constants.Gender;
import com.greektrust.constants.Status;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
    @Test
    public void isNameMatchShouldSayTrueWhenGivenNameMatchesWhenPersonIsMale() {
        Person person = new Person("Shan", Gender.MALE);
        assertTrue(person.isNameMatch("Shan"));
    }

    @Test
    public void isNameMatchShouldSayTrueWhenGivenNameMatchesWhenPersonIsFemale() {
        Person person = new Person("Anga", Gender.FEMALE);
        assertTrue(person.isNameMatch("Anga"));
    }

    @Test
    public void isNameMatchShouldSayFalseWhenGivenNameDoesNotMatchesWhenPersonIsMale() {
        Person person = new Person("Shan", Gender.MALE);
        assertFalse(person.isNameMatch("Anga"));
    }

    @Test
    public void isNameMatchShouldSayFalseWhenGivenNameDoesNotMatchesWhenPersonIsFemale() {
        Person person = new Person("Anga", Gender.FEMALE);
        assertFalse(person.isNameMatch("Shan"));
    }

    @Test
    public void isPartnerNameMatchShouldSayTrueWhenGivenNameMatchesWithPartnerNameWhenPersonIsMale() {
        Person person = new Person("Shan", Gender.MALE);
        person.addPartner(new Person("Anga", Gender.FEMALE));
        assertTrue(person.isPartner("Anga"));
    }

    @Test
    public void isPartnerNameMatchShouldSayTrueWhenGivenNameMatchesWithPartnerNameWhenPersonIsFemale() {
        Person person = new Person("Anga", Gender.FEMALE);
        person.addPartner(new Person("Shan", Gender.MALE));
        assertTrue(person.isPartner("Shan"));
    }

    @Test
    public void isPartnerNameMatchShouldSayFalseWhenGivenNameNotMatchesWithPartnerNameWhenPersonIsMale() {
        Person person = new Person("Shan", Gender.MALE);
        person.addPartner(new Person("Anga", Gender.FEMALE));
        assertFalse(person.isPartner("Vich"));
    }

    @Test
    public void isPartnerNameMatchShouldSayShouldSayFalseWhenGivenNameDoesNotMatchesWithPartnerNameWhenPersonIsFemale() {
        Person person = new Person("Anga", Gender.FEMALE);
        person.addPartner(new Person("Shan", Gender.MALE));
        assertFalse(person.isPartner("Vich"));
    }

    @Test
    public void isChildPresentShouldSayTrueWhenChildIsPresent() {
        Person person = new Person("Shan", Gender.MALE);
        Person partner = new Person("Anga", Gender.FEMALE);
        person.addPartner(partner);
        partner.addChild(new Person("Vich", Gender.MALE));
        partner.addChild(new Person("Ish", Gender.MALE));

        assertTrue(partner.isChildPresent("Ish"));
    }

    @Test
    public void isChildPresentShouldSayFalseWhenChildIsNotPresent() {
        Person person = new Person("Shan", Gender.MALE);
        Person partner = new Person("Anga", Gender.FEMALE);
        person.addPartner(partner);
        partner.addChild(new Person("Vich", Gender.MALE));
        partner.addChild(new Person("Ish", Gender.MALE));

        assertFalse(person.isChildPresent("Anga"));
    }

    @Test
    public void findPersonShouldFindThePersonWithGivenNameWhenItsKingItselfAndGiveThatPerson() {
        Person person = new Person("Shan", Gender.MALE);
        person.addPartner(new Person("Anga", Gender.FEMALE));


        assertEquals(person, person.findPerson("Shan"));
    }

    @Test
    public void findPersonShouldFindThePersonWithGivenNameWhenItsQueenItselfAndGiveThatPerson() {
        Person person = new Person("Shan", Gender.MALE);
        Person partner = new Person("Anga", Gender.FEMALE);
        person.addPartner(partner);

        assertEquals(partner, person.findPerson("Anga"));
    }

    @Test
    public void findPersonShouldFindThePersonWithGivenNameWhenItsKingsOnlyChildAndGiveThatPerson() {
        Person person = new Person("Shan", Gender.MALE);
        Person partner = new Person("Anga", Gender.FEMALE);
        person.addPartner(partner);
        Person ish = new Person("Ish", Gender.MALE);
        partner.addChild(ish);


        assertEquals(ish, person.findPerson("Ish"));
    }

    @Test
    public void findPersonShouldFindThePersonWithGivenNameWhenItsOneOfKingsChildAndGiveThatPerson() {
        Person person = new Person("Shan", Gender.MALE);
        Person partner = new Person("Anga", Gender.FEMALE);
        person.addPartner(partner);
        partner.addChild(new Person("Vich", Gender.MALE));
        Person ish = new Person("Ish", Gender.MALE);
        partner.addChild(ish);


        assertEquals(ish, person.findPerson("Ish"));
    }

    @Test
    public void findPersonShouldFindThePersonWithGivenNameWhenItsOneOfKingsGrandChildAndGiveThatPerson() {
        Person person = new Person("Shan", Gender.MALE);
        Person partner = new Person("Anga", Gender.FEMALE);
        person.addPartner(partner);
        Person child = new Person("Satya", Gender.FEMALE);
        partner.addChild(child);
        Person childPartner = new Person("Vyan", Gender.MALE);
        child.addPartner(childPartner);
        Person grandChild = new Person("Asva", Gender.MALE);
        child.addChild(grandChild);


        assertEquals(grandChild, person.findPerson("Asva"));
    }

    @Test
    public void findPersonShouldFindThePersonWithGivenNameWhenItsOneOfKingsGrandChildPartnerAndGiveThatPerson() {
        Person person = new Person("Shan", Gender.MALE);
        Person partner = new Person("Anga", Gender.FEMALE);
        person.addPartner(partner);
        Person child = new Person("Satya", Gender.FEMALE);
        partner.addChild(child);
        Person childPartner = new Person("Vyan", Gender.MALE);
        child.addPartner(childPartner);
        Person grandChild = new Person("Asva", Gender.MALE);
        child.addChild(grandChild);
        Person grandChildPartner = new Person("Satvy", Gender.FEMALE);
        grandChild.addPartner(grandChildPartner);


        assertEquals(grandChildPartner, person.findPerson("Satvy"));
    }

    @Test
    public void addChildShouldSayCHILD_ADDITION_FAILEDWhenPersonIsNotAFemale() {
        Person person = new Person("Shan", Gender.MALE);
        assertEquals(Status.CHILD_ADDITION_FAILED, person.addChild(new Person("Divya", Gender.FEMALE)));
    }

    @Test
    public void addChildShouldAddChildAndSayCHILD_ADDITION_SUCCEEDEDWhenPersonIsAFemale() {
        Person person = new Person("Anga", Gender.FEMALE);
        assertEquals(Status.CHILD_ADDITION_SUCCEEDED, person.addChild(new Person("Divya", Gender.FEMALE)));
    }
}
