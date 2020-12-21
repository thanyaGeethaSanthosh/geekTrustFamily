package com.greektrust.structure;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NodeTest {
    @Test
    public void isNameMatchShouldSayTrueWhenGivenNameMatches() {
        Node node = new Node("Shan");
        assertTrue(node.isNameMatch("Shan"));
    }

    @Test
    public void isNameMatchShouldSayFalseWhenGivenNameDoesNotMatches() {
        Node node = new Node("Shan");
        assertFalse(node.isNameMatch("Anga"));
    }

    @Test
    public void isLeftNextNameMatchShouldSayTrueWhenGivenNameMatchesWithLeftNext() {
        Node node = new Node("Shan");
        node.addLeftNext("Anga");
        assertTrue(node.isLeftNextNameMatch("Anga"));
    }

    @Test
    public void isLeftNextNameMatchShouldSayShouldSayFalseWhenGivenNameDoesNotMatchesWithLeftNext() {
        Node node = new Node("Shan");
        node.addLeftNext("Anga");
        assertFalse(node.isLeftNextNameMatch("Vich"));
    }

    @Test
    public void isAnyRightNextNameMatchShouldSayTrueWhenGivenNameMatchesWithAnyNodeInRightNext() {
        Node node = new Node("Shan");
        node.addToRightNext("Vich");
        node.addToRightNext("Ish");
        assertTrue(node.isAnyRightNextNameMatch("Ish"));
    }

    @Test
    public void isAnyRightNextNameMatchShouldSayFalseWhenGivenNameDoesNotMatchesWithAnyNodeInRightNext() {
        Node node = new Node("Shan");
        node.addToRightNext("Vich");
        node.addToRightNext("Ish");
        assertFalse(node.isAnyRightNextNameMatch("Anga"));
    }
}
