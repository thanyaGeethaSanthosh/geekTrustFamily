package com.greektrust.structure;

import com.greektrust.constants.Gender;
import com.greektrust.constants.Status;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void getChildrenShouldGiveChildrenOfGivenFemalePerson() {
        Person person = new Person("Anga", Gender.FEMALE);
        Person child1 = new Person("Ish", Gender.MALE);
        Person child2 = new Person("Vich", Gender.MALE);
        Person child3 = new Person("Satya", Gender.FEMALE);
        person.addChild(child1);
        person.addChild(child2);
        person.addChild(child3);
        ArrayList<Person> children = new ArrayList<>();
        children.add(child1);
        children.add(child2);
        children.add(child3);

        assertEquals(children, person.getChildren());
    }

    @Test
    public void getChildrenShouldGiveChildrenOfGivenMalePerson() {
        Person person = new Person("Shan", Gender.MALE);
        Person partner = new Person("Anga", Gender.FEMALE);
        person.addPartner(partner);
        Person child1 = new Person("Ish", Gender.MALE);
        partner.addChild(child1);
        Person child2 = new Person("Vich", Gender.MALE);
        partner.addChild(child2);
        Person child3 = new Person("Satya", Gender.FEMALE);
        partner.addChild(child3);
        ArrayList<Person> children = new ArrayList<>();
        children.add(child1);
        children.add(child2);
        children.add(child3);

        assertEquals(children, person.getChildren());
    }

    @Test
    public void isFemaleShouldSayTrueWhenPersonIsFemale() {
        Person person = new Person("Anga", Gender.FEMALE);

        assertTrue(person.isFemale());
    }

    @Test
    public void isFemaleShouldSayFalseWhenPersonIsNotFemale() {
        Person person = new Person("Shan", Gender.MALE);

        assertFalse(person.isFemale());
    }

    @Test
    public void findSonShouldFindTheSonFromFather() {
        Person person = new Person("Shan", Gender.MALE);
        Person partner = new Person("Anga", Gender.FEMALE);
        person.addPartner(partner);
        Person child1 = new Person("Ish", Gender.MALE);
        Person child2 = new Person("Vich", Gender.MALE);
        Person child3 = new Person("Satya", Gender.FEMALE);
        partner.addChild(child1);
        partner.addChild(child2);
        partner.addChild(child3);
        List<Person> son = new ArrayList<>();
        son.add(child1);
        son.add(child2);

        assertEquals(son, person.findSons());
    }

    @Test
    public void findSonShouldFindTheSonFromMother() {
        Person person = new Person("Shan", Gender.MALE);
        Person partner = new Person("Anga", Gender.FEMALE);
        person.addPartner(partner);
        Person child1 = new Person("Ish", Gender.MALE);
        Person child2 = new Person("Vich", Gender.MALE);
        Person child3 = new Person("Satya", Gender.FEMALE);
        partner.addChild(child1);
        partner.addChild(child2);
        partner.addChild(child3);
        List<Person> son = new ArrayList<>();
        son.add(child1);
        son.add(child2);

        assertEquals(son, partner.findSons());
    }

    @Test
    public void findDaughterShouldFindTheDaughtersForGivenFatherName() {
        Person person = new Person("Shan", Gender.MALE);
        Person partner = new Person("Anga", Gender.FEMALE);
        person.addPartner(partner);
        Person child1 = new Person("Ish", Gender.MALE);
        Person child2 = new Person("Vich", Gender.MALE);
        Person child3 = new Person("Satya", Gender.FEMALE);
        partner.addChild(child1);
        partner.addChild(child2);
        partner.addChild(child3);
        List<Person> daughter = new ArrayList<>();
        daughter.add(child3);

        assertEquals(daughter, person.findDaughters());
    }

    @Test
    public void findSiblingsShouldFindTheSiblingsForGivenFatherName() {
        Person person = new Person("Shan", Gender.MALE);
        Person partner = new Person("Anga", Gender.FEMALE);
        person.addPartner(partner);
        Person child1 = new Person("Ish", Gender.MALE);
        Person child2 = new Person("Vich", Gender.MALE);
        Person child3 = new Person("Satya", Gender.FEMALE);
        partner.addChild(child1);
        partner.addChild(child2);
        partner.addChild(child3);
        List<Person> siblings = new ArrayList<>();
        siblings.add(child1);
        siblings.add(child2);

        assertEquals(siblings, child3.findSiblings());
    }

    @Test
    public void shouldFindPaternalUncleForAPerson() {
        Person person = new Person("Shan", Gender.MALE);
        Person partner = new Person("Anga", Gender.FEMALE);
        person.addPartner(partner);

        Person child1 = new Person("Ish", Gender.MALE);
        Person child2 = new Person("Vich", Gender.MALE);
        Person child3 = new Person("Satya", Gender.FEMALE);
        partner.addChild(child1);
        partner.addChild(child2);
        partner.addChild(child3);

        Person child2Partner = new Person("Lika", Gender.FEMALE);
        child2.addPartner(child2Partner);

        Person grandChild = new Person("Vila", Gender.FEMALE);
        child2Partner.addChild(grandChild);

        List<Person> paternalUncles = new ArrayList<>();
        paternalUncles.add(child1);

        assertEquals(paternalUncles, grandChild.findPaternalUncles());
    }

    @Test
    public void shouldFindPaternalAuntForAPerson() {
        Person person = new Person("Shan", Gender.MALE);
        Person partner = new Person("Anga", Gender.FEMALE);
        person.addPartner(partner);

        Person child1 = new Person("Ish", Gender.MALE);
        Person child2 = new Person("Vich", Gender.MALE);
        Person child3 = new Person("Satya", Gender.FEMALE);
        partner.addChild(child1);
        partner.addChild(child2);
        partner.addChild(child3);

        Person child2Partner = new Person("Lika", Gender.FEMALE);
        child2.addPartner(child2Partner);

        Person grandChild = new Person("Vila", Gender.FEMALE);
        child2Partner.addChild(grandChild);

        List<Person> paternalAunt = new ArrayList<>();
        paternalAunt.add(child3);

        assertEquals(paternalAunt, grandChild.findPaternalAunts());
    }

    @Test
    public void shouldFindMaternalUncleForAPerson() {
        Person person = new Person("Shan", Gender.MALE);
        Person partner = new Person("Anga", Gender.FEMALE);
        person.addPartner(partner);

        Person child1 = new Person("Ish", Gender.MALE);
        Person child2 = new Person("Vich", Gender.MALE);
        Person child3 = new Person("Satya", Gender.FEMALE);
        partner.addChild(child1);
        partner.addChild(child2);
        partner.addChild(child3);

        Person child3Partner = new Person("Vyan", Gender.MALE);
        child3.addPartner(child3Partner);

        Person grandChild = new Person("Asva", Gender.MALE);
        child3.addChild(grandChild);

        List<Person> maternalUncles = new ArrayList<>();
        maternalUncles.add(child1);
        maternalUncles.add(child2);

        assertEquals(maternalUncles, grandChild.findMaternalUncles());
    }

    @Test
    public void shouldFindMaternalAuntForAPerson() {
        Person person = new Person("Shan", Gender.MALE);
        Person partner = new Person("Anga", Gender.FEMALE);
        person.addPartner(partner);

        Person child1 = new Person("Amba", Gender.FEMALE);
        Person child2 = new Person("Vich", Gender.MALE);
        Person child3 = new Person("Satya", Gender.FEMALE);
        partner.addChild(child1);
        partner.addChild(child2);
        partner.addChild(child3);

        Person child3Partner = new Person("Vyan", Gender.MALE);
        child3.addPartner(child3Partner);

        Person grandChild = new Person("Asva", Gender.MALE);
        child3.addChild(grandChild);

        List<Person> maternalAunt = new ArrayList<>();
        maternalAunt.add(child1);

        assertEquals(maternalAunt, grandChild.findMaternalAunts());
    }

    @Test
    public void shouldFindSistersHusbandsAsBrotherInLawForAPerson() {
        Person shan = new Person("Shan", Gender.MALE);
        Person anga = new Person("Anga", Gender.FEMALE);
        shan.addPartner(anga);

        Person vich = new Person("Vich", Gender.MALE);
        Person satya = new Person("Satya", Gender.FEMALE);

        anga.addChild(vich);
        anga.addChild(satya);

        Person vyan = new Person("Vyan", Gender.MALE);
        satya.addPartner(vyan);

        List<Person> brothersInLaw = new ArrayList<>();
        brothersInLaw.add(vyan);

        assertEquals(brothersInLaw, vich.findBrothersInLaw());

    }

    @Test
    public void shouldFindBrothersOfPartnerAsBrotherInLawForAPerson() {
        Person shan = new Person("Shan", Gender.MALE);
        Person anga = new Person("Anga", Gender.FEMALE);
        shan.addPartner(anga);

        Person vich = new Person("Vich", Gender.MALE);
        Person satya = new Person("Satya", Gender.FEMALE);
        anga.addChild(vich);
        anga.addChild(satya);

        Person vyan = new Person("Vyan", Gender.MALE);
        satya.addPartner(vyan);

        List<Person> brothersInLaw = new ArrayList<>();
        brothersInLaw.add(vich);

        assertEquals(brothersInLaw, vyan.findBrothersInLaw());

    }

    @Test
    public void shouldFindBrothersWivesAsSisterInLawForAPerson() {
        Person shan = new Person("Shan", Gender.MALE);
        Person anga = new Person("Anga", Gender.FEMALE);
        shan.addPartner(anga);

        Person vich = new Person("Vich", Gender.MALE);
        Person satya = new Person("Satya", Gender.FEMALE);

        anga.addChild(vich);
        anga.addChild(satya);

        Person lika = new Person("Lika", Gender.FEMALE);
        vich.addPartner(lika);

        List<Person> sistersInLaw = new ArrayList<>();
        sistersInLaw.add(lika);

        assertEquals(sistersInLaw, satya.findSistersInLaw());

    }

    @Test
    public void shouldFindSistersOfPartnerAsSisterInLawForAPerson() {
        Person shan = new Person("Shan", Gender.MALE);
        Person anga = new Person("Anga", Gender.FEMALE);
        shan.addPartner(anga);

        Person vich = new Person("Vich", Gender.MALE);
        Person satya = new Person("Satya", Gender.FEMALE);

        anga.addChild(vich);
        anga.addChild(satya);

        Person lika = new Person("Lika", Gender.FEMALE);
        vich.addPartner(lika);

        List<Person> sistersInLaw = new ArrayList<>();
        sistersInLaw.add(lika);

        assertEquals(sistersInLaw, satya.findSistersInLaw());

    }
}
