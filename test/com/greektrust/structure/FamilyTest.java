package com.greektrust.structure;

import com.greektrust.constants.Gender;
import com.greektrust.constants.Status;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FamilyTest {

    @Test
    public void addChildShouldSayPERSON_NOT_FOUNDWhenPersonDoesNotExistForGivenMotherName() {
        Family family = new Family("Shan", Gender.MALE);
        assertEquals(Status.PERSON_NOT_FOUND, family.addChild("Anga", "Ish", Gender.MALE));

    }

    @Test
    public void addChildShouldSayCHILD_ADDITION_FAILEDWhenGivenPersonNameIsNotFemale() {
        Family family = new Family("Shan", Gender.MALE);
        assertEquals(Status.CHILD_ADDITION_FAILED, family.addChild("Shan", "Ish", Gender.MALE));

    }

    @Test
    public void addChildShouldSayCHILD_ADDITION_SUCCEEDEDWhenGivenPersonNameIsFemale() {
        Family family = new Family("Shan", Gender.MALE);
        family.addPartner("Shan", "Anga", Gender.FEMALE);
        assertEquals(Status.CHILD_ADDITION_SUCCEEDED, family.addChild("Anga", "Ish", Gender.MALE));

    }
}