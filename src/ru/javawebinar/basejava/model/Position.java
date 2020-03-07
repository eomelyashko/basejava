package ru.javawebinar.basejava.model;

import java.time.LocalDate;
import java.util.Objects;

public class Position {
    private final String header;
    private final String description;

    private final LocalDate fromDate;
    private final LocalDate toDate;

    private final Link link;

    public Position(String header, String description, LocalDate fromDate, LocalDate toDate, String value, String link) {
        Objects.requireNonNull(header, "header must not be null");
        Objects.requireNonNull(fromDate, "fromDate must not be null");
        Objects.requireNonNull(toDate, "toDate must not be null");
        this.header = header;
        this.description = description;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.link = new Link(value, link);
    }

    public String getHeader() {
        return header;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
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
        if (description != null ? !description.equals(position.description) : position.description != null)
            return false;
        if (!fromDate.equals(position.fromDate)) return false;
        if (!toDate.equals(position.toDate)) return false;
        return link.equals(position.link);
    }

    @Override
    public int hashCode() {
        int result = header.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + fromDate.hashCode();
        result = 31 * result + toDate.hashCode();
        result = 31 * result + link.hashCode();
        return result;
    }

    @Override
    public String toString() {
        String today = toDate == null ? "Сейчас" : toDate.toString();
        return "Position{" +
                "header='" + header + '\'' +
                ", description='" + description + '\'' +
                ", fromData=" + fromDate +
                ", toData=" + today +
                ", link='" + link + '\'' +
                '}';
    }
}
