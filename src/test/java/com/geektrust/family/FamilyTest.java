package com.geektrust.family;

import com.geektrust.constants.Gender;
import com.geektrust.constants.Relationship;
import com.geektrust.constants.ChildAdditionStatus;
import com.geektrust.exceptions.PersonNotFountException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FamilyTest {

    @Test
    public void shouldSayPERSON_NOT_FOUNDWhenPersonDoesNotExistForGivenMotherName() {
        Family family = new Family(new Person("Shan", Gender.MALE));
        Person child = new Person("Ish", Gender.MALE);

        assertThrows(PersonNotFountException.class, () -> family.addChild("Anga", child));
    }

    @Test
    public void shouldSayCHILD_ADDITION_FAILEDWhenGivenPersonNameIsNotFemale() throws PersonNotFountException {
        Family family = new Family(new Person("Shan", Gender.MALE));
        Person child = new Person("Ish", Gender.MALE);

        assertEquals(ChildAdditionStatus.CHILD_ADDITION_FAILED, family.addChild("Shan", child));
    }

    @Test
    public void shouldSayCHILD_ADDITION_SUCCEEDEDWhenGivenPersonNameIsFemale() throws PersonNotFountException {
        Family family = new Family(new Person("Shan", Gender.MALE));
        Person partner = new Person("Anga", Gender.FEMALE);
        family.addPartner("Shan", partner);
        Person child = new Person("Ish", Gender.MALE);

        assertEquals(ChildAdditionStatus.CHILD_ADDITION_SUCCEEDED, family.addChild("Anga", child));
    }

    @Test
    public void shouldFindListOfSonForGivenMotherName() throws PersonNotFountException {
        Person person = new Person("Shan", Gender.MALE);
        Family family = new Family(person);
        Person partner = new Person("Anga", Gender.FEMALE);
        family.addPartner("Shan", partner);
        Person child1 = new Person("Ish", Gender.MALE);
        Person child2 = new Person("Vich", Gender.MALE);
        Person child3 = new Person("Satya", Gender.FEMALE);
        family.addChild("Anga", child1);
        family.addChild("Anga", child2);
        family.addChild("Anga", child3);
        List<Person> son = new ArrayList<>();
        son.add(child1);
        son.add(child2);

        assertEquals(son, family.findRelatives("Anga", Relationship.SON));
    }

    @Test
    public void shouldFindListOfSonForGivenFatherName() throws PersonNotFountException {
        Person person = new Person("Shan", Gender.MALE);
        Family family = new Family(person);
        Person partner = new Person("Anga", Gender.FEMALE);
        family.addPartner("Shan", partner);
        Person child1 = new Person("Ish", Gender.MALE);
        Person child2 = new Person("Vich", Gender.MALE);
        Person child3 = new Person("Satya", Gender.FEMALE);
        family.addChild("Anga", child1);
        family.addChild("Anga", child2);
        family.addChild("Anga", child3);
        List<Person> son = new ArrayList<>();
        son.add(child1);
        son.add(child2);

        assertEquals(son, family.findRelatives("Shan", Relationship.SON));
    }

    @Test
    public void shouldFindListOfDaughtersForGivenFatherName() throws PersonNotFountException {
        Person person = new Person("Shan", Gender.MALE);
        Family family = new Family(person);
        Person partner = new Person("Anga", Gender.FEMALE);
        family.addPartner("Shan", partner);
        Person child1 = new Person("Ish", Gender.MALE);
        Person child2 = new Person("Vich", Gender.MALE);
        Person child3 = new Person("Satya", Gender.FEMALE);
        family.addChild("Anga", child1);
        family.addChild("Anga", child2);
        family.addChild("Anga", child3);
        List<Person> daughter = new ArrayList<>();
        daughter.add(child3);

        assertEquals(daughter, family.findRelatives("Shan", Relationship.DAUGHTER));
    }

    @Test
    public void shouldFindSiblingsForGivenChildName() throws PersonNotFountException {
        Person person = new Person("Shan", Gender.MALE);
        Family family = new Family(person);
        Person partner = new Person("Anga", Gender.FEMALE);
        family.addPartner("Shan", partner);
        Person child1 = new Person("Ish", Gender.MALE);
        Person child2 = new Person("Vich", Gender.MALE);
        Person child3 = new Person("Satya", Gender.FEMALE);
        family.addChild("Anga", child1);
        family.addChild("Anga", child2);
        family.addChild("Anga", child3);
        List<Person> siblings = new ArrayList<>();
        siblings.add(child1);
        siblings.add(child2);

        assertEquals(siblings, family.findRelatives("Satya", Relationship.SIBLINGS));
    }

    @Test
    public void shouldFindPaternalUncleForGivenPersonName() throws PersonNotFountException {
        Person person = new Person("Shan", Gender.MALE);
        Family family = new Family(person);
        Person partner = new Person("Anga", Gender.FEMALE);
        family.addPartner("Shan", partner);

        Person child1 = new Person("Ish", Gender.MALE);
        Person child2 = new Person("Vich", Gender.MALE);
        Person child3 = new Person("Satya", Gender.FEMALE);
        family.addChild("Anga", child1);
        family.addChild("Anga", child2);
        family.addChild("Anga", child3);

        Person child2Partner = new Person("Lika", Gender.FEMALE);
        family.addPartner("Vich", child2Partner);

        Person grandChild = new Person("Vila", Gender.FEMALE);
        family.addChild("Lika", grandChild);

        List<Person> paternalUncles = new ArrayList<>();
        paternalUncles.add(child1);

        assertEquals(paternalUncles, family.findRelatives("Vila", Relationship.PATERNAL_UNCLE));
    }

    @Test
    public void shouldFindPaternalAuntForGivenPersonName() throws PersonNotFountException {
        Person person = new Person("Shan", Gender.MALE);
        Family family = new Family(person);
        Person partner = new Person("Anga", Gender.FEMALE);
        family.addPartner("Shan", partner);

        Person child1 = new Person("Ish", Gender.MALE);
        Person child2 = new Person("Vich", Gender.MALE);
        Person child3 = new Person("Satya", Gender.FEMALE);
        family.addChild("Anga", child1);
        family.addChild("Anga", child2);
        family.addChild("Anga", child3);

        Person child2Partner = new Person("Lika", Gender.FEMALE);
        family.addPartner("Vich", child2Partner);

        Person grandChild = new Person("Vila", Gender.FEMALE);
        family.addChild("Lika", grandChild);

        List<Person> paternalAunt = new ArrayList<>();
        paternalAunt.add(child3);

        assertEquals(paternalAunt, family.findRelatives("Vila", Relationship.PATERNAL_AUNT));
    }

    @Test
    public void shouldFindMaternalUncleForGivenPersonName() throws PersonNotFountException {
        Person person = new Person("Shan", Gender.MALE);
        Family family = new Family(person);
        Person partner = new Person("Anga", Gender.FEMALE);
        family.addPartner("Shan", partner);

        Person child1 = new Person("Ish", Gender.MALE);
        Person child2 = new Person("Vich", Gender.MALE);
        Person child3 = new Person("Satya", Gender.FEMALE);
        family.addChild("Anga", child1);
        family.addChild("Anga", child2);
        family.addChild("Anga", child3);

        Person child3Partner = new Person("Vyan", Gender.MALE);
        family.addPartner("Satya", child3Partner);

        Person grandChild = new Person("Asva", Gender.MALE);
        family.addChild("Satya", grandChild);

        List<Person> paternalUncles = new ArrayList<>();
        paternalUncles.add(child1);
        paternalUncles.add(child2);

        assertEquals(paternalUncles, family.findRelatives("Asva", Relationship.MATERNAL_UNCLE));
    }

    @Test
    public void shouldFindMaternalAuntForGivenPersonName() throws PersonNotFountException {
        Person person = new Person("Shan", Gender.MALE);
        Family family = new Family(person);
        Person partner = new Person("Anga", Gender.FEMALE);
        family.addPartner("Shan", partner);

        Person child1 = new Person("Amba", Gender.FEMALE);
        Person child2 = new Person("Vich", Gender.MALE);
        Person child3 = new Person("Satya", Gender.FEMALE);
        family.addChild("Anga", child1);
        family.addChild("Anga", child2);
        family.addChild("Anga", child3);

        Person child3Partner = new Person("Vyan", Gender.MALE);
        family.addPartner("Satya", child3Partner);

        Person grandChild = new Person("Asva", Gender.MALE);
        family.addChild("Satya", grandChild);

        List<Person> maternalAunts = new ArrayList<>();
        maternalAunts.add(child1);

        assertEquals(maternalAunts, family.findRelatives("Asva", Relationship.MATERNAL_AUNT));
    }

    @Test
    public void shouldFindSistersHusbandsAsBrotherInLawForAPerson() throws PersonNotFountException {
        Person shan = new Person("Shan", Gender.MALE);
        Family family = new Family(shan);
        Person anga = new Person("Anga", Gender.FEMALE);
        family.addPartner("Shan", anga);

        Person vich = new Person("Vich", Gender.MALE);
        Person satya = new Person("Satya", Gender.FEMALE);

        family.addChild("Anga", vich);
        family.addChild("Anga", satya);

        Person vyan = new Person("Vyan", Gender.MALE);
        family.addPartner("Satya", vyan);

        List<Person> brothersInLaw = new ArrayList<>();
        brothersInLaw.add(vyan);

        assertEquals(brothersInLaw, family.findRelatives("Vich", Relationship.BROTHER_IN_LAW));
    }

    @Test
    public void shouldFindBrothersOfPartnerAsBrotherInLawForAPerson() throws PersonNotFountException {
        Person shan = new Person("Shan", Gender.MALE);
        Family family = new Family(shan);
        Person anga = new Person("Anga", Gender.FEMALE);
        family.addPartner("Shan", anga);

        Person vich = new Person("Vich", Gender.MALE);
        Person satya = new Person("Satya", Gender.FEMALE);

        family.addChild("Anga", vich);
        family.addChild("Anga", satya);

        Person vyan = new Person("Vyan", Gender.MALE);
        family.addPartner("Satya", vyan);

        List<Person> brothersInLaw = new ArrayList<>();
        brothersInLaw.add(vich);

        assertEquals(brothersInLaw, family.findRelatives("Vyan", Relationship.BROTHER_IN_LAW));
    }


    @Test
    public void shouldFindBrothersWivesAsSisterInLawForAPerson() throws PersonNotFountException {
        Person shan = new Person("Shan", Gender.MALE);
        Family family = new Family(shan);
        Person anga = new Person("Anga", Gender.FEMALE);
        family.addPartner("Shan", anga);

        Person vich = new Person("Vich", Gender.MALE);
        Person satya = new Person("Satya", Gender.FEMALE);

        family.addChild("Anga", vich);
        family.addChild("Anga", satya);

        Person lika = new Person("Lika", Gender.FEMALE);
        family.addPartner("Vich", lika);

        List<Person> sistersInLaw = new ArrayList<>();
        sistersInLaw.add(lika);

        assertEquals(sistersInLaw, family.findRelatives("Satya", Relationship.SISTER_IN_LAW));
    }

    @Test
    public void shouldFindSistersOfPartnerAsSisterInLawForAPerson() throws PersonNotFountException {
        Person shan = new Person("Shan", Gender.MALE);
        Family family = new Family(shan);
        Person anga = new Person("Anga", Gender.FEMALE);
        family.addPartner("Shan", anga);

        Person vich = new Person("Vich", Gender.MALE);
        Person satya = new Person("Satya", Gender.FEMALE);

        family.addChild("Anga", vich);
        family.addChild("Anga", satya);

        Person lika = new Person("Lika", Gender.FEMALE);
        family.addPartner("Vich", lika);

        List<Person> sistersInLaw = new ArrayList<>();
        sistersInLaw.add(satya);

        assertEquals(sistersInLaw, family.findRelatives("Lika", Relationship.SISTER_IN_LAW));
    }

    @Test
    public void shouldGiveSisterInLawAsNullForAPersonWhoDoesNotExist(){
        Person shan = new Person("Shan", Gender.MALE);
        Family family = new Family(shan);
        Person anga = new Person("Anga", Gender.FEMALE);
        family.addPartner("Shan", anga);

        assertThrows(PersonNotFountException.class, () -> family.findRelatives("Lika", Relationship.SISTER_IN_LAW));
    }
}