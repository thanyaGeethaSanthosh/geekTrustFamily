package com.greektrust.structure;

import com.greektrust.constants.Gender;
import org.junit.Test;

import static org.junit.Assert.*;

public class WomenTest {
    @Test
    public void isNameMatchShouldSayTrueWhenGivenNameMatches() {
        Women women = new Women("Anga");
        assertTrue(women.isNameMatch("Anga"));
    }

    @Test
    public void isNameMatchShouldSayFalseWhenGivenNameDoesNotMatches() {
        Women women = new Women("Anga");
        assertFalse(women.isNameMatch("Shan"));
    }

    @Test
    public void isPartnerNameMatchShouldSayTrueWhenGivenNameMatchesWithPartnerName() {
        Women women = new Women("Anga");
        women.addPartner("Shan");
        assertTrue(women.isPartnerNameMatch("Shan"));
    }

    @Test
    public void isPartnerNameMatchShouldSayShouldSayFalseWhenGivenNameDoesNotMatchesWithPartnerName() {
        Women women = new Women("Anga");
        women.addPartner("Shan");
        assertFalse(women.isPartnerNameMatch("Vich"));
    }

    @Test
    public void isChildPresentShouldSayTrueWhenChildIsPresent() {
        Women women = new Women("Shan");
        women.addChild("Vich", Gender.MALE);
        women.addChild("Ish",Gender.MALE);
        assertTrue(women.isChildPresent("Ish"));
    }

    @Test
    public void isChildPresentShouldSayFalseWhenChildIsNotPresent() {
        Women women = new Women("Shan");
        women.addChild("Vich",Gender.MALE);
        women.addChild("Ish",Gender.MALE);
        assertFalse(women.isChildPresent("Anga"));
    }

    @Test
    public void findWomenShouldFindThePersonWithGivenNameWhenItsQueenItselfAndGiveThatPerson() {
        Women women = new Women("Anga");
        women.addChild("Vich",Gender.MALE);
        women.addChild("Ish",Gender.MALE);
        women.addPartner("Shan");
        assertEquals(women, women.findPerson("Anga"));

    }

    @Test
    public void findPersonShouldFindThePersonWithGivenNameWhenItsKingItselfAndGiveThatPerson() {
        Women women = new Women("Anga");
        women.addChild("Vich",Gender.MALE);
        women.addChild("Ish",Gender.MALE);
        women.addPartner("Shan");

        Person shan = new Person("Shan");
        shan.addPartner("Anga");

        assertEquals(shan,women.findPerson("Shan"));
    }

    @Test
    public void findPersonShouldFindThePersonWithGivenNameWhenItsOneOfKingsChildAndGiveThatPerson() {
        Women women = new Women("Anga");
        women.addChild("Vich",Gender.MALE);
        women.addChild("Ish",Gender.MALE);
        women.addPartner("Shan");

        Person ish = new Person("Ish",women);

        assertEquals(ish, women.findPerson("Ish"));
    }
}