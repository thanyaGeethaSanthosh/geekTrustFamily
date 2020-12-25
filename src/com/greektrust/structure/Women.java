package com.greektrust.structure;

public class Women extends Person {
    private final Children children;
    private Person partner;

    public Women(String name) {
        super(name);
        this.children = new Children();
    }

    public Women(Person partner, String name) {
        super(name);
        this.partner = partner;
        this.children = new Children();
    }

    public Women(String name, Women mother) {
        super(name,mother);
        this.children = new Children();
    }

    @Override
    public boolean isPartnerNameMatch(String name) {
        return this.partner.isNameMatch(name);
    }

    public void addPartner(String  partnerName) {
        this.partner=new Person(this,partnerName);
    }

    public void addChild(String name) {
        Person rightNext = new Person(name);
        this.children.add(rightNext);
    }

    public boolean isChildPresent(String name) {
        return this.children.isChildPresent(name);
    }
}
