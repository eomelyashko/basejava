package ru.javawebinar.basejava.model;

public class Profile implements Section {
    String value;

    public Profile(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "value='" + value + '\'' +
                '}';
    }
}
