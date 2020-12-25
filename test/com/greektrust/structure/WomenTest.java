package com.greektrust.structure;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WomenTest {
    @Test
    public void isNameMatchShouldSayTrueWhenGivenNameMatches() {
        Women women = new Women( "Anga");
        assertTrue(women.isNameMatch("Anga"));
    }

    @Test
    public void isNameMatchShouldSayFalseWhenGivenNameDoesNotMatches() {
        Women women = new Women( "Anga");
        assertFalse(women.isNameMatch("Shan"));
    }

    @Test
    public void isPartnerNameMatchShouldSayTrueWhenGivenNameMatchesWithPartnerName() {
        Women women = new Women( "Anga");
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
        Women women = new Women( "Shan");
        women.addChild("Vich");
        women.addChild("Ish");
        assertTrue(women.isChildPresent("Ish"));
    }

    @Test
    public void isChildPresentShouldSayFalseWhenChildIsNotPresent() {
        Women women = new Women( "Shan");
        women.addChild("Vich");
        women.addChild("Ish");
        assertFalse(women.isChildPresent("Anga"));
    }
}