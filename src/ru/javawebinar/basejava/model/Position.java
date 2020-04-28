package ru.javawebinar.basejava.model;

import java.util.List;
import java.util.Objects;

public class Position {
    private final String header;

    private List<Heading> listHeading;

    private final Link link;

    public Position(String header, String value, String link, Heading ... headings) {
        Objects.requireNonNull(header, "header must not be null");
        this.header = header;
        this.link = new Link(value, link);
    }

    public String getHeader() {
        return header;
    }

    public Link getLink() {
        return link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (!header.equals(position.header)) return false;
        if (!listHeading.equals(position.listHeading)) return false;
        return link.equals(position.link);
    }

    @Override
    public int hashCode() {
        int result = header.hashCode();
        result = 31 * result + link.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Position{" +
                "header='" + header + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
