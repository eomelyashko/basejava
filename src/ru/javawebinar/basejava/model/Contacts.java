package ru.javawebinar.basejava.model;

public class Contacts {
    String value;
    String link;

    public Contacts(String value, String link) {
        this.value = value;
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
    public String toString() {
        return "Contacts{" +
                "value='" + value + '\'' +
                '}';
    }
}
