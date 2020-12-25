package com.greektrust.structure;

import com.greektrust.exceptions.PersonNotFountException;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChildrenTest {

    @Test
    public void addAllShouldAddAllTheChildInTheGivenChildren() {
        Children list = new Children();

        Children list1 = new Children();
        list1.add(new Person("Ish"));
        list1.add(new Person("Vich"));

        Children list2 = new Children();
        list2.add(new Person("Aras"));
        list2.add(new Person("Satya"));

        Children children = new Children();
        children.add(new Person("Ish"));
        children.add(new Person("Vich"));
        children.add(new Person("Aras"));
        children.add(new Person("Satya"));

        list.addAll(list1);
        list.addAll(list2);

        assertEquals(children, list);
    }

    @Test
    public void isChildPresentShouldSayTrueWhenChildIsPResent() {
        Children children = new Children();
        children.add(new Person("Vich"));
        children.add(new Person("Ish"));
        assertTrue(children.isChildPresent("Ish"));
    }

    @Test
    public void isChildPresentShouldSayFalseWhenChildIsNotPResent() {
        Children children = new Children();
        children.add(new Person("Vich"));
        children.add(new Person("Ish"));
        assertFalse(children.isChildPresent("Anga"));
    }

    @Test
    public void findChildShouldFindTheChildWhenPresentInChildren() {
        Children children = new Children();
        children.add(new Person("Ish"));
        children.add(new Person("Vich"));
        children.add(new Person("Satya"));
        try {
            assertEquals(new Person("Ish"), children.findChild("Ish"));
        } catch (PersonNotFountException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findChildShouldThrowPersonNotFoundExceptionWhenChildNotPresentInChildren() {
        Children children = new Children();
        children.add(new Person("Ish"));
        children.add(new Person("Vich"));
        children.add(new Person("Satya"));
        try {
            children.findChild("Ish");
        } catch (PersonNotFountException e) {
            assertEquals(e.getMessage(), "PERSON_NOT_FOUND");
        }
    }
}