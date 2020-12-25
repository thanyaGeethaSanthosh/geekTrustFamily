package com.greektrust.structure;

import com.greektrust.exceptions.PersonNotFountException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ChildrenTest {

    @Test
    public void addAllShouldAddAllTheChildInTheGivenChildren() {
        Children list = new Children();

        Children list1 = new Children();
        list1.add(new Node("Ish"));
        list1.add(new Node("Vich"));

        Children list2 = new Children();
        list2.add(new Node("Aras"));
        list2.add(new Node("Satya"));

        Children children = new Children();
        children.add(new Node("Ish"));
        children.add(new Node("Vich"));
        children.add(new Node("Aras"));
        children.add(new Node("Satya"));

        list.addAll(list1);
        list.addAll(list2);

        assertEquals(children, list);
    }

    @Test
    public void findChildShouldFindTheChildWhenPresentInChildren() {
        Children children = new Children();
        children.add(new Node("Ish"));
        children.add(new Node("Vich"));
        children.add(new Node("Satya"));
        try {
            assertEquals(new Node("Ish"), children.findChild("Ish"));
        } catch (PersonNotFountException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findChildShouldThrowPersonNotFoundExceptionWhenChildNotPresentInChildren() {
        Children children = new Children();
        children.add(new Node("Ish"));
        children.add(new Node("Vich"));
        children.add(new Node("Satya"));
        try {
            children.findChild("Ish");
        } catch (PersonNotFountException e) {
            assertEquals(e.getMessage(),"PERSON_NOT_FOUND");
        }
    }
}