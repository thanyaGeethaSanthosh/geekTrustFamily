package com.greektrust.structure;

import com.greektrust.constants.Gender;
import com.greektrust.constants.Status;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FamilyTest {

    @Test
    public void addChildShouldSayPERSON_NOT_FOUNDWhenPersonDoesNotExistForGivenMotherName() {
        Family family = new Family(new Person("Shan", Gender.MALE));
        Person child = new Person("Ish", Gender.MALE);

        assertEquals(Status.PERSON_NOT_FOUND, family.addChild("Anga", child));

    }

    @Test
    public void addChildShouldSayCHILD_ADDITION_FAILEDWhenGivenPersonNameIsNotFemale() {
        Family family = new Family(new Person("Shan", Gender.MALE));
        Person child = new Person("Ish", Gender.MALE);

        assertEquals(Status.CHILD_ADDITION_FAILED, family.addChild("Shan", child));

    }

    @Test
    public void addChildShouldSayCHILD_ADDITION_SUCCEEDEDWhenGivenPersonNameIsFemale() {
        Family family = new Family(new Person("Shan", Gender.MALE));
        Person partner = new Person("Anga", Gender.FEMALE);
        family.addPartner("Shan", partner);
        Person child = new Person("Ish", Gender.MALE);

        assertEquals(Status.CHILD_ADDITION_SUCCEEDED, family.addChild("Anga", child));

    }

    @Test
    public void findSonShouldFindTheSonForGivenMotherName() {
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

        assertEquals(son, family.findSon("Anga"));
    }

    @Test
    public void findSonShouldFindTheSonForGivenFatherName() {
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

        assertEquals(son, family.findSon("Shan"));
    }
}