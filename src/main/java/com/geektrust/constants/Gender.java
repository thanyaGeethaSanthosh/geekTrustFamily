package com.geektrust.constants;

public enum Gender {
    MALE, FEMALE;

    public boolean isFemale() {
        return this == FEMALE;
    }
}
