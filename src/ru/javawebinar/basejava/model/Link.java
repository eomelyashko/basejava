package ru.javawebinar.basejava.model;

import java.util.Objects;

public class Link {
    private String value;
    private String link;

    public Link(String value, String link) {
        Objects.requireNonNull(value, "value must not be null");
        this.value = value;
        this.link = link;
    }

    public Link(String value) {
        this(value, "");
    }

    public String getValue() {
        return value;
    }

    public String getLink() {
        return link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        if (!value.equals(link.value)) return false;
        return this.link != null ? this.link.equals(link.link) : link.link == null;
    }

    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * result + (link != null ? link.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Link(" + value + ',' + link + ')';
    }
}
