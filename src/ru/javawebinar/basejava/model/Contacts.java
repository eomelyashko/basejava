package ru.javawebinar.basejava.model;

import java.util.Objects;

public class Contacts {
    private String value;
    private String link;

    public Contacts(String value, String link) {
        Objects.requireNonNull(value, "value must not be null");
        this.value = value;
        this.link = link;
    }

    public Contacts(String value) {
        this(value, "");
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contacts contacts = (Contacts) o;

        return value.equals(contacts.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return "{" +
                "value='" + value + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
