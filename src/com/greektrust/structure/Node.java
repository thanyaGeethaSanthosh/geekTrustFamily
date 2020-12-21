package com.greektrust.structure;

import java.util.ArrayList;

public class Node {
    private final String name;
    private final ArrayList<Node> rightNext;
    private Node leftNext;

    public Node(String name) {
        this.name = name;
        this.leftNext = null;
        this.rightNext = new ArrayList<>();
    }

    public void addLeftNext(String name) {
        this.leftNext = new Node(name);
    }

    public void addToRightNext(String name) {
        Node rightNext = new Node(name);
        this.rightNext.add(rightNext);
    }

    public boolean isNameMatch(String name) {
        return this.name.equals(name);
    }

    public boolean isLeftNextNameMatch(String name) {
        return this.leftNext.isNameMatch(name);
    }

    public boolean isAnyRightNextNameMatch(String name) {
        for (Node node : this.rightNext) {
            if (node.isNameMatch(name)) {
                return true;
            }
        }
        return false;
    }
}
