package com.pluralsightP1.conferencedemo.models;

import java.util.Objects;

public class Test {
    private String text;
    private String location;

    public Test(String text, String location) {
        this.text = text;
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return text.equals(test.text) && location.equals(test.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, location);
    }

}
