package com.greektrust.structure;

public class Family {
    private final Node parent;

    public Family(String parentName) {
        this.parent = new Node(parentName);
    }

    public void addChild(String parentName, String childName) {
        this.parent.addToRightNext(childName);
    }

}
