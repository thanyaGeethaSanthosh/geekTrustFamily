package com.greektrust.structure;

import com.greektrust.exceptions.PersonNotFountException;

import java.util.ArrayList;
import java.util.Objects;

public class Children {
    private final ArrayList<Node> nodes;

    public Children() {
        this.nodes = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Children children = (Children) o;
        return Objects.equals(nodes, children.nodes);
    }

    public void addAll(Children list){
        this.nodes.addAll(list.nodes);
    }

    public void add(Node child){
        this.nodes.add(child);
    }

    public Node findChild(String childName) throws PersonNotFountException {
        for (Node node : this.nodes) {
            if (node.isNameMatch(childName)){
                return node;
            }
        }
        throw new PersonNotFountException();
    }

}
