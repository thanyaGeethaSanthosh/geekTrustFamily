package com.greektrust.structure;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PersonTest {
    @Test
    public void isNameMatchShouldSayTrueWhenGivenNameMatches() {
        Person person = new Person("Shan");
        assertTrue(person.isNameMatch("Shan"));
    }

    @Test
    public void isNameMatchShouldSayFalseWhenGivenNameDoesNotMatches() {
        Person person = new Person("Shan");
        assertFalse(person.isNameMatch("Anga"));
    }

    @Test
    public void isPartnerNameMatchShouldSayTrueWhenGivenNameMatchesWithPartnerName() {
        Person person = new Person("Shan");
        person.addPartner( "Anga");
        assertTrue(person.isPartnerNameMatch("Anga"));
    }

    @Test
    public void isPartnerNameMatchShouldSayFalseWhenGivenNameNotMatchesWithPartnerName() {
        Person person = new Person("Shan");
        person.addPartner( "Anga");
        assertFalse(person.isPartnerNameMatch("Vich"));
    }
}
