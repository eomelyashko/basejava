package ru.javawebinar.basejava.model;

import java.time.LocalDate;
import java.util.Objects;

public class Position {
    private String header;
    private String description;

    private LocalDate fromData;
    private LocalDate toData;

    private String link;

    public Position(String header, String description, LocalDate fromData, LocalDate toData, String link) {
        Objects.requireNonNull(header, "header must not be null");
        Objects.requireNonNull(description, "description must not be null");
        Objects.requireNonNull(fromData, "fromData must not be null");
        this.header = header;
        this.description = description;
        this.fromData = fromData;
        this.toData = toData;
        this.link = link;
    }

    public Position(String header, String description, LocalDate fromData, LocalDate toData) {
        this(header, description, fromData, toData, "");
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getFromData() {
        return fromData;
    }

    public void setFromData(LocalDate fromData) {
        this.fromData = fromData;
    }

    public LocalDate getToData() {
        return toData;
    }

    public void setToData(LocalDate toData) {
        this.toData = toData;
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

        Position that = (Position) o;

        if (!header.equals(that.header)) return false;
        return description.equals(that.description);
    }

    @Override
    public int hashCode() {
        int result = header.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }

    @Override
    public String toString() {
        String today = toData == null ? "Сейчас" : toData.toString();
        return "Position{" +
                "header='" + header + '\'' +
                ", description='" + description + '\'' +
                ", fromData=" + fromData +
                ", toData=" + today +
                ", link='" + link + '\'' +
                '}';
    }
}
