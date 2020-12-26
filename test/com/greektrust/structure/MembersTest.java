package com.greektrust.structure;

import com.greektrust.exceptions.PersonNotFountException;
import org.junit.Test;

import static org.junit.Assert.*;

public class MembersTest {

    @Test
    public void addAllShouldAddAllTheChildInTheGivenChildren() {
        Members list = new Members();

        Members list1 = new Members();
        list1.add(new Person("Ish"));
        list1.add(new Person("Vich"));

        Members list2 = new Members();
        list2.add(new Person("Aras"));
        list2.add(new Person("Satya"));

        Members members = new Members();
        members.add(new Person("Ish"));
        members.add(new Person("Vich"));
        members.add(new Person("Aras"));
        members.add(new Person("Satya"));

        list.addAll(list1);
        list.addAll(list2);

        assertEquals(members, list);
    }

    @Test
    public void isChildPresentShouldSayTrueWhenChildIsPResent() {
        Members members = new Members();
        members.add(new Person("Vich"));
        members.add(new Person("Ish"));
        assertTrue(members.isChildPresent("Ish"));
    }

    @Test
    public void isChildPresentShouldSayFalseWhenChildIsNotPResent() {
        Members members = new Members();
        members.add(new Person("Vich"));
        members.add(new Person("Ish"));
        assertFalse(members.isChildPresent("Anga"));
    }

    @Test
    public void findChildShouldFindTheChildWhenPresentInChildren() {
        Members members = new Members();
        members.add(new Person("Ish"));
        members.add(new Person("Vich"));
        members.add(new Person("Satya"));
        try {
            assertEquals(new Person("Ish"), members.findChild("Ish"));
        } catch (PersonNotFountException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findChildShouldThrowPersonNotFoundExceptionWhenChildNotPresentInChildren() {
        Members members = new Members();
        members.add(new Person("Ish"));
        members.add(new Person("Vich"));
        members.add(new Person("Satya"));
        try {
            members.findChild("Ish");
        } catch (PersonNotFountException e) {
            assertEquals(e.getMessage(), "PERSON_NOT_FOUND");
        }
    }
}